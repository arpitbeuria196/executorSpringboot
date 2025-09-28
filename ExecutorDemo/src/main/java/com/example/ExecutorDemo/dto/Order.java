package com.example.ExecutorDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Order {
    int count;
    List<String> orderName;

}
