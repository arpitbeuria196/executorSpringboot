package com.example.ExecutorDemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserReport {

    Order order;
    Payment payment;
    User user;
    long fetchInMilisecond;

}
