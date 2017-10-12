package com.epayment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.epayment.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.epayment"})
public class EPaymentApp {

	public static void main(String[] args) {
		SpringApplication.run(EPaymentApp.class, args);
	}
}
