package com.john.feign.client;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystrix implements FeignServiceClient{

	@Override
	public String home(String name) {
		// TODO Auto-generated method stub
		return "error!!!";
	}

}
