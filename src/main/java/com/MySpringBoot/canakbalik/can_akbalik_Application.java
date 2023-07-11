package com.MySpringBoot.canakbalik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class can_akbalik_Application {

	public static void main(String[] args) {
		SpringApplication.run(can_akbalik_Application.class, args);
	}

	@GetMapping("/customer")
	public String Welcome(@RequestParam(value = "name", defaultValue = "Salih")String name){
		return String.format("Welcome %s",name);
	}

}
