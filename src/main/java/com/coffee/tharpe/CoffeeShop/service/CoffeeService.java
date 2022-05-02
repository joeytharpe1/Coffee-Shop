package com.coffee.tharpe.CoffeeShop.service;

import com.coffee.tharpe.CoffeeShop.entity.Coffee;
import com.coffee.tharpe.CoffeeShop.error.CoffeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CoffeeService {
    //post a coffee class
    Coffee saveCoffee(Coffee coffee);

    //get all coffee
    List<Coffee> fetchCoffeeList();

    //get a coffee and if not found throw custom exception
    Coffee fetchCoffeeById(Long coffeeId) throws CoffeeNotFoundException;

    //delete a coffee
    String deleteCoffeeById(Long coffeeId) throws CoffeeNotFoundException;

    //update a coffee
    Coffee updateCoffee(Long coffeeId, Coffee coffee) throws CoffeeNotFoundException;

    //get coffee by a name
    Coffee fetchCoffeeByName(String coffeeName);
}

