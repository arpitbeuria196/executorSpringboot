package com.example.ExecutorDemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ExecutorConfig {

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor()
    {
        ThreadPoolTaskExecutor ex = new ThreadPoolTaskExecutor();

        ex.setCorePoolSize(4);
        ex.setMaxPoolSize(6);
        ex.setQueueCapacity(10);
        ex.setKeepAliveSeconds(30);
        ex.setThreadNamePrefix("async-");
        ex.setWaitForTasksToCompleteOnShutdown(true);
        ex.initialize();

        return ex;

    }
}
