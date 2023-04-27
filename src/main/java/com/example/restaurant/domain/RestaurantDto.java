package com.example.restaurant.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class RestaurantDto {
    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "createAt")
    private LocalDateTime createAt;
}
