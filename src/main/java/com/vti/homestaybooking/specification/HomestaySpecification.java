package com.vti.homestaybooking.specification;

import com.vti.homestaybooking.entity.Homestay;
import com.vti.homestaybooking.form.HomestayFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HomestaySpecification {
    public static Specification<Homestay> buildSpec(HomestayFilterForm form) {
        return form == null ? null : new Specification<Homestay>() {
            @Override
            public Predicate toPredicate(Root<Homestay> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                String search = form.getSearch();
                if (StringUtils.hasText(search)) {
                    String pattern = "%" + search.trim() + "%";
                    Predicate hasTitleLike = criteriaBuilder.like(root.get("title"), pattern);
                    predicates.add(hasTitleLike);
                }
                var minCreatedDate = form.getMinCreatedDate();
                if (minCreatedDate != null) {
                    var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                    var predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt").as(LocalDateTime.class),
                            minCreatedAt);
                    predicates.add(predicate);
                }
                var maxCreatedDate = form.getMaxCreatedDate();
                if (maxCreatedDate != null) {
                    var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                    var predicate = criteriaBuilder.lessThanOrEqualTo(root.get("createdAt").as(LocalDateTime.class),
                            maxCreatedAt);
                    predicates.add(predicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }

}
