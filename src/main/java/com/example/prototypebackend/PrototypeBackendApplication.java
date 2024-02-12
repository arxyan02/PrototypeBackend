package com.example.prototypebackend;

import com.example.prototypebackend.Models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class PrototypeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeBackendApplication.class, args);
	}

}
