package com.example.ExecutorDemo.service;

import com.example.ExecutorDemo.dto.Order;
import com.example.ExecutorDemo.dto.Payment;
import com.example.ExecutorDemo.dto.User;
import com.example.ExecutorDemo.dto.UserReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportService {

    public final AsyncService asyncService;

    public CompletableFuture<UserReport> getAllUserReport() throws InterruptedException {

        long t0 = System.currentTimeMillis();

        CompletableFuture<User> userF = asyncService.fetchAllUsers();
        CompletableFuture<Payment> payF = asyncService.fetchPaymentData();
        CompletableFuture<Order> orderF = asyncService.fetchOrderData();

        CompletableFuture<?> all = CompletableFuture.allOf(userF,payF,orderF);//waiting to finish all tasks success or failure

        return all.thenApply(v-> {
            long elapsed = System.currentTimeMillis() - t0;
            return new UserReport(orderF.join(),payF.join(),userF.join(),elapsed);
        });

    }
}
