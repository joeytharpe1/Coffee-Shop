package com.coffee.tharpe.CoffeeShop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long coffeeId;

    @Column(name = "NAME")
    @NotBlank(message = "Please add a coffee shop name")
    @Size(min = 3, max = 100, message = "name must be more than 2 characters and less than 100 characters")
    private String coffeeName;

    @Column(name = "ADDRESS")
    @NotBlank(message = "Please add a coffee shop address")
    private String coffeeAddress;

    @Column(name = "PHONE_NUMBER")
    @NotBlank(message = "Please add a coffee shop phone number")
    private String coffeePhone;

    @Column(name = "EMAIL")
    @NotEmpty(message = "Email cannot be empty")
    private String coffeeEmail;
}
