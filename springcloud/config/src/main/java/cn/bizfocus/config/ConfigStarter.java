package cn.bizfocus.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigStarter {
	public static void main(String[] args) {
		SpringApplication.run(ConfigStarter.class, args);
	}
}
