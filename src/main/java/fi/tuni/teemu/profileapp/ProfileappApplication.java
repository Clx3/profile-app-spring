package fi.tuni.teemu.profileapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"fi.tuni.teemu.profileapp.configuration",
		"fi.tuni.teemu.profileapp.controller",
		"fi.tuni.teemu.profileapp.service",
})
public class ProfileappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileappApplication.class, args);
	}

}
