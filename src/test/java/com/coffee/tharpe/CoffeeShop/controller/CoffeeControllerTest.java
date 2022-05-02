package com.coffee.tharpe.CoffeeShop.controller;

import com.coffee.tharpe.CoffeeShop.entity.Coffee;
import com.coffee.tharpe.CoffeeShop.service.CoffeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeController.class)
class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoffeeService coffeeService;

    private Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = Coffee.builder()
                .coffeeAddress("Arizona")
                .coffeeEmail("wowzer@email.com")
                .coffeeName("WowCoffee")
                .coffeePhone("4804548752")
                .coffeeId(1L)
                .build();

    }

    @Test
    void saveCoffee() throws Exception {
        Coffee inputCoffee = Coffee.builder()
                .coffeeAddress("Arizona")
                .coffeeEmail("wowzer@email.com")
                .coffeeName("WowCoffee")
                .coffeePhone("4804548752")
                .build();

        Mockito.when(coffeeService.saveCoffee(inputCoffee))
                .thenReturn(coffee);

        mockMvc.perform(post("/coffee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "coffeeName" : "WowCoffee",
                            "coffeeAddress" : "Arizona",
                            "coffeePhone" : "4804548752",
                            "coffeeEmail" : "wowzer@email.com"
                        }"""))
                .andExpect(status().isOk());
    }

    @Test
    void fetchCoffeeById() throws Exception{
        Mockito.when(coffeeService.fetchCoffeeById(1L))
                .thenReturn(coffee);

        mockMvc.perform(get("/coffee/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coffeeName")
                        .value(coffee.getCoffeeName()));
    }
}