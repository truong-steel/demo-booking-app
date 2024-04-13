package com.vti.homestaybooking.dto;

import com.vti.homestaybooking.controller.HomestayController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class HomestayDto extends RepresentationModel<HomestayDto> {
    private Long id;

    private String homestayName;

    private String homestayType;

    private String city;

    private String address;

    private String description;

    private Blob homestayImg;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<RoomDto> rooms;

    public HomestayDto withSelfRel() {
        if (rooms != null) {
            for(RoomDto room : rooms){
                room.withSelfRel();
            }
        }
        var controller = methodOn(HomestayController.class);

        var dto = controller.getHomestayById(id);

        var link = linkTo(dto).withSelfRel();

        return add(link);
    }

}
