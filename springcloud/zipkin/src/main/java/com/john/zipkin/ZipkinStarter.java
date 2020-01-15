package com.john.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinStarter {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinStarter.class, args);
	}
}
