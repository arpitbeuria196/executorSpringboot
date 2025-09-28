package com.example.ExecutorDemo.service;


import com.example.ExecutorDemo.dto.Order;
import com.example.ExecutorDemo.dto.Payment;
import com.example.ExecutorDemo.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {

    @Async("asyncExecutor")
    public CompletableFuture<User> fetchAllUsers() throws InterruptedException {
        log.info("FetchingUserData on {}",Thread.currentThread().getName());
        Thread.sleep(2000);
        User newUser = new User(1L,"Arpit","arpitbeuria196@gmail.com");

        return CompletableFuture.completedFuture(newUser);

    }

    @Async("asyncExecutor")
    public CompletableFuture<Order> fetchOrderData() throws InterruptedException {
        log.info("Fetching order Data {}",Thread.currentThread().getName());
        Thread.sleep(3000);
        List<String> list = List.of("pen","Notebook","dress");
        Order order = new Order(3,list);

        return CompletableFuture.completedFuture(order);
    }

    @Async("asyncExecutor")
    public CompletableFuture<Payment> fetchPaymentData() throws InterruptedException {
        log.info("Fetching Payment Data {}",Thread.currentThread().getName());
        Thread.sleep(4000);
        Payment payment = new Payment("online",100L);
        return CompletableFuture.completedFuture(payment);
    }


}
