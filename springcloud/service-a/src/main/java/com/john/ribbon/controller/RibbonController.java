package com.john.ribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.ribbon.service.RibbonService;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class RibbonController {

	private final Logger logger = LoggerFactory.getLogger(RibbonController.class);
	
	String port;

    @Autowired
    private Environment environment;
	
	@RequestMapping("/ribbon")
	public String home(@RequestParam String name) throws UnknownHostException {
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		InetAddress ia = InetAddress.getLocalHost();
		String host = ia.getHostName();//获取计算机主机名
		String IP= ia.getHostAddress();//获取计算机IP
		logger.warn("this is service-ribbon!!!" + " ip :" + IP + " host :" + host);
		System.out.println("hi "+name+",i am from port:" + environment.getProperty("server.port"));
	    return "hi "+name+",i am from port:" + environment.getProperty("server.port") + " ip :" + IP + " host :" + host;
	}
	
	@Autowired
	private RibbonService ribbonService;
		
	@RequestMapping("/test")
	public String test(@RequestParam String name){
		return ribbonService.test(name);
	}
}
