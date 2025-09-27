package com.example.ExecutorDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@Slf4j
public class ExecutorDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ExecutorDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				4,
				6,
				30,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(10));

		log.info("Before Starting for Loop",Thread.currentThread().getName());
		int rejected=0;
		for(int i=1;i<=20;i++)
		{
			int id =i;

			try
			{
				executor.submit(()->doWork(id));
			} catch (Exception e) {
				rejected++;
				log.warn("Rejected tasks ->{}",id);

			}
			log.warn("Total Rejected tasks ->{}",rejected);


		}

		log.info("After Starting for Loop",Thread.currentThread().getName());

	}

	private void doWork(int id)
	{
		String t = Thread.currentThread().getName();
		log.info("Task-{} START on {}", id, t);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		log.info("Task-{} END   on {}", id, t);
	}
}





