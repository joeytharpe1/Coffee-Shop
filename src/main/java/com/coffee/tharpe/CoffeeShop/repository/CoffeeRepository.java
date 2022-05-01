package com.coffee.tharpe.CoffeeShop.repository;

import com.coffee.tharpe.CoffeeShop.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
