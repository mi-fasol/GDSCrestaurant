package com.example.restaurant;

import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class RestaurantApplicationTests {

	@Autowired
	RestaurantService restaurantService;


	@Test
	public void contextLoads() {

		restaurantService.deleteRestaurant(2L);
	}
}
