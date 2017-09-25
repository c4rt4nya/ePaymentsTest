package com.mifinity.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.mifinity.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.mifinity"})
public class MiFinityApp {

	public static void main(String[] args) {
		SpringApplication.run(MiFinityApp.class, args);
	}
}
