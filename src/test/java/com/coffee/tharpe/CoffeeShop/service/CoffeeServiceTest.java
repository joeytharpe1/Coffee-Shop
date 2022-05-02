package com.coffee.tharpe.CoffeeShop.service;

import com.coffee.tharpe.CoffeeShop.entity.Coffee;
import com.coffee.tharpe.CoffeeShop.error.CoffeeNotFoundException;
import com.coffee.tharpe.CoffeeShop.repository.CoffeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoffeeServiceTest {

    @Autowired
    private CoffeeService coffeeService;

    @MockBean
    private CoffeeRepository coffeeRepository;

    @BeforeEach
    void setUp() {
        Coffee coffee = Coffee.builder()
                .coffeeId(1L)
                .coffeeName("Yummies")
                .coffeeAddress("California")
                .coffeePhone("9098765432")
                .coffeeEmail("Yumm@email.com")
                .build();


        Mockito.when(coffeeRepository.findByCoffeeNameIgnoreCase("Yummies"))
                .thenReturn(coffee);

        Mockito.when(coffeeRepository.findById(1L)).thenReturn(Optional.ofNullable(coffee));

    }


    @Test
    void whenValidCoffeeId_thenCoffeeShouldBeFound() throws CoffeeNotFoundException {
        Long coffeeId = 1L;
        Coffee found = coffeeService.fetchCoffeeById(coffeeId);

        assertEquals(coffeeId, found.getCoffeeId(), "no id found");
    }


    @Test
    @DisplayName("Get data based on valid coffee name")
    void whenValidCoffeeName_thenCoffeeShouldBeFound() {
        String coffeeName = "Yummies";
        Coffee found = coffeeService.fetchCoffeeByName(coffeeName);

        assertEquals(coffeeName, found.getCoffeeName(), "not valid coffee name");
    }


}