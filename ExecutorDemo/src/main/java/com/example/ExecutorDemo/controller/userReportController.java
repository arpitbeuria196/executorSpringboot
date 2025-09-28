package com.example.ExecutorDemo.controller;


import com.example.ExecutorDemo.dto.UserReport;
import com.example.ExecutorDemo.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class userReportController {

    private final ReportService reportService;

    @GetMapping("/report")
    public CompletableFuture<UserReport> getReport() throws InterruptedException {
        return reportService.getAllUserReport();
    }

}
