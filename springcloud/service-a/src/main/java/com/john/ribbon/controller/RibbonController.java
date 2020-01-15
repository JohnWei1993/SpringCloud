package com.john.ribbon.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.ribbon.service.RibbonService;

@RestController
public class RibbonController {

	private final Logger logger = Logger.getLogger(getClass());
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/ribbon")
	public String home(@RequestParam String name) {
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		logger.warn("this is service-ribbon!!!");
	    return "hi "+name+",i am from port:" +port;
	}
	
	@Autowired
	private RibbonService ribbonService;
		
	@RequestMapping("/test")
	public String test(@RequestParam String name){
		return ribbonService.test(name);
	}
}
