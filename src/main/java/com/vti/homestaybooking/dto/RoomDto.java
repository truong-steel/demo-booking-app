package com.vti.homestaybooking.dto;

import com.vti.homestaybooking.controller.RoomController;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class RoomDto extends RepresentationModel<RoomDto> {
    private Long id;

    private BigDecimal roomPrice ;

    private Blob roomImage;

    private String roomDescription;
    private String roomType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RoomDto withSelfRel() {
        var controller = methodOn(RoomController.class);
        var dto = controller.findById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}