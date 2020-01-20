package com.john.gateway;

import javax.servlet.http.HttpServletRequest;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessFilter extends ZuulFilter{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

//        Object accessToken = request.getParameter("accessToken");
//        if(accessToken == null) {
//        	logger.warn("access token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        }
        logger.info("access token ok");
        return null;
	}

	//控制过滤器生效不生效，可以在里面写一串逻辑来控制
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	//自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 四种类型：pre,routing,error,post
	// pre：主要用在路由映射的阶段是寻找路由映射表的
	// routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
	// error:一旦前面的过滤器出错了，会调用error过滤器。
	// post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}
	
}
