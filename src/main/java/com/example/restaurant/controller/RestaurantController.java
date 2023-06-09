package com.example.restaurant.controller;

import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.domain.RestaurantDto;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private final RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public List<Restaurant> findAllRestaurant() {
        return restaurantService.findAllRestaurant();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RestaurantDto findRestaurantById(@PathVariable Long id) {
        return restaurantService.findRestaurantById(id);
    }

    @PutMapping("/{id}/{category}")
    public Restaurant updateRestaurant(@PathVariable Long id, @PathVariable String category) {
        return restaurantService.updateRestaurant(id, category);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
