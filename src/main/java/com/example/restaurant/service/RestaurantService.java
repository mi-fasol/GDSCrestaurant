package com.example.restaurant.service;

import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.domain.RestaurantDto;
import com.example.restaurant.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {return restaurantRepository.save(restaurant);}

    public List<Restaurant> findAllRestaurant(){
        return restaurantRepository.findAll();
    }

    public RestaurantDto findRestaurantById(Long id) {
        Restaurant restaurantData =  restaurantRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        RestaurantDto dto = new RestaurantDto();
        dto.setName(restaurantData.getName());
        dto.setCategory(restaurantData.getCategory());
        dto.setCreateAt(restaurantData.getCreateAt());

        return dto;
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, String category){
        Restaurant restaurantData = restaurantRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        restaurantData.setCategory(category);
        return restaurantRepository.save(restaurantData);
    }

    public void deleteRestaurant(Long id){
        restaurantRepository.deleteById(id);
    }

}
