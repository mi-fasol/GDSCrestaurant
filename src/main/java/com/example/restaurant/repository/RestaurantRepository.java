package com.example.restaurant.repository;


import com.example.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}