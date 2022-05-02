package com.coffee.tharpe.CoffeeShop.service;

import com.coffee.tharpe.CoffeeShop.entity.Coffee;
import com.coffee.tharpe.CoffeeShop.error.CoffeeNotFoundException;
import com.coffee.tharpe.CoffeeShop.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeServiceImpl implements CoffeeService{

    //repository to be used for crud operations
    private final CoffeeRepository coffeeRepository;

    //(autowired) my repository
    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    //creating a coffee service implementation
    @Override
    public Coffee saveCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    //getting all coffee service implementation
    @Override
    public List<Coffee> fetchCoffeeList() {
        return coffeeRepository.findAll();
    }

    //getting a single coffee service implementation
    @Override
    public Coffee fetchCoffeeById(Long coffeeId) throws CoffeeNotFoundException {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(coffeeId);
        if(!coffeeOptional.isPresent()){
            throw new CoffeeNotFoundException("Coffee with id: "+coffeeId+" not found");
        }
        return coffeeOptional.get();
    }

    //deleting a coffee by id service implementation
    @Override
    public String deleteCoffeeById(Long coffeeId) throws CoffeeNotFoundException {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(coffeeId);
        if(!coffeeOptional.isPresent())
            throw new CoffeeNotFoundException("Coffee with id: "+coffeeId+" not found");
            coffeeRepository.deleteById(coffeeId);
        return "coffee with id: " + coffeeId + " has been deleted";
    }

    //updating a coffee service implementation
    @Override
    public Coffee updateCoffee(Long coffeeId, Coffee coffee) throws CoffeeNotFoundException {
        Optional<Coffee> coffeeToUpdateOptional = coffeeRepository.findById(coffeeId);
        //if no id is found
        if(!coffeeToUpdateOptional.isPresent())
            throw new CoffeeNotFoundException("Coffee with id: "+coffeeId+" not found");

        Coffee coffeeToUpdate = coffeeToUpdateOptional.get();

        if(coffee.getCoffeeEmail() != null)
            coffeeToUpdate.setCoffeeEmail(coffee.getCoffeeEmail());

        if(coffee.getCoffeeName() != null)
            coffeeToUpdate.setCoffeeName(coffee.getCoffeeName());

        if(coffee.getCoffeeAddress() != null)
            coffeeToUpdate.setCoffeeAddress(coffee.getCoffeeAddress());

        if(coffee.getCoffeePhone() != null)
            coffeeToUpdate.setCoffeePhone(coffee.getCoffeePhone());

        return coffeeRepository.save(coffeeToUpdate);
    }

    @Override
    public Coffee fetchCoffeeByName(String coffeeName){
        return coffeeRepository.findByCoffeeNameIgnoreCase(coffeeName);
    }
}
