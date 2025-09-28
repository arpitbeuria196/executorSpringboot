package com.example.ExecutorDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    String paymentMethod;
    Long amount;


}
