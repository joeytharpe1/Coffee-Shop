package com.coffee.tharpe.CoffeeShop.repository;

import com.coffee.tharpe.CoffeeShop.entity.Coffee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CoffeeRepositoryTest {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Coffee coffee = Coffee.builder()
                .coffeeEmail("crape@email.com")
                .coffeePhone("1219098655")
                .coffeeName("CrapesTho")
                .coffeeAddress("Australia")
                .build();

        entityManager.persist(coffee);
    }

    @Test
    public void whenFindById_thenReturnCoffee(){
        Coffee coffee = coffeeRepository.findById(1L).get();
        assertEquals(coffee.getCoffeeName(), "CrapesTho");
    }
}