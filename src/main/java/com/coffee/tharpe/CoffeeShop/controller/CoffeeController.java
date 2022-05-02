package com.coffee.tharpe.CoffeeShop.controller;

import com.coffee.tharpe.CoffeeShop.entity.Coffee;
import com.coffee.tharpe.CoffeeShop.error.CoffeeNotFoundException;
import com.coffee.tharpe.CoffeeShop.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    private final CoffeeService coffeeService;
    public final Logger LOGGER = Logger.getLogger(String.valueOf(CoffeeController.class));
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    //create a coffee
    @PostMapping()
    public Coffee saveCoffee(@Valid @RequestBody Coffee coffee){
        LOGGER.info("Inside saveCoffee of CoffeeController");
        return coffeeService.saveCoffee(coffee);
    }

    //get all coffee's
    @GetMapping()
    public List<Coffee> fetchCoffeeList(){
        LOGGER.info("Inside fetchCoffeeList of CoffeeController");
        return coffeeService.fetchCoffeeList();
    }

    //get one coffee
    @GetMapping("/{id}")
    public Coffee fetchCoffeeById(@PathVariable("id") Long coffeeId) throws CoffeeNotFoundException {
        LOGGER.info("Inside fetchCoffeeById of CoffeeController");
        return coffeeService.fetchCoffeeById(coffeeId);
    }

    //delete a coffee
    @DeleteMapping("/{id}")
    public String deleteCoffeeById(@PathVariable("id") Long coffeeId) throws CoffeeNotFoundException {
        LOGGER.info("Inside deleteCoffeeById of CoffeeController");
        return coffeeService.deleteCoffeeById(coffeeId);
    }

    //update a coffee
    @PutMapping("/{id}")
    public Coffee updateCoffee(@Valid @PathVariable("id") Long coffeeId, @RequestBody Coffee coffee) throws CoffeeNotFoundException{
        LOGGER.info("Inside updateCoffee of CoffeeController");
        return coffeeService.updateCoffee(coffeeId, coffee);
    }

    //get coffee by name
    @GetMapping("/name/{name}")
    public Coffee fetchCoffeeByName(@PathVariable("name") String coffeeName){
        LOGGER.info("inside fetchCoffeeByName of CoffeeController");
        return coffeeService.fetchCoffeeByName(coffeeName);
    }
}
