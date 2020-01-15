package com.john.feign.controller;

import com.john.feign.client.FeignServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

	@Value("${server.port}")
	String port;
	
	@Autowired
	private FeignServiceClient feignServiceClient;
	
	@RequestMapping("/feign")
	public String home(@RequestParam String name) {
	    return "hi "+name+",i am from port:" +port;
	}
	
	@RequestMapping("/test")
	public String test(@RequestParam String name){
		return feignServiceClient.home(name);
	}
}
