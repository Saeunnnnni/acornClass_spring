package com.example.boot6;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot6WebConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot6WebConfigApplication.class, args);
		/*
		 * Runtime rt = Runtime.getRuntime(); try {
		 * rt.exec("cmd /c start chrome.exe http://localhost:9000/boot6"); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
	}

}