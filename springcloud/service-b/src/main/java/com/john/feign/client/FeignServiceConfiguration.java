package com.john.feign.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration
public class FeignServiceConfiguration {
	@Bean
    Retryer feignRetryer() {
        return Retryer.NEVER_RETRY;
    }
}
