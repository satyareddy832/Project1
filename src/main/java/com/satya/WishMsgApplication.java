package com.satya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class WishMsgApplication {
	
	public static void main(String[] args) {
		String url="http://localhost:9999/api/helper";
		RestTemplate restTemplate=new RestTemplate();
		SpringApplication.run(WishMsgApplication.class, args);
		System.out.println("this is main Function");
		restTemplate.getForObject(url, String.class);
	}

}
