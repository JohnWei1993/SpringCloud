package cn.bizfocus.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="Service-ribbon", fallback= FeignServiceHystrix.class, configuration= FeignServiceConfiguration.class)
public interface FeignServiceClient {
	
	@RequestMapping("/ribbon")
	public String home(@RequestParam("name") String name);
}
