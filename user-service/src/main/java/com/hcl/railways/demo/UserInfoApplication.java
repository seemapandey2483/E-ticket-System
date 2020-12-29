package com.hcl.railways.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//import com.hcl.railways.demo.config.RibbonConfiguration;
import com.hcl.railways.demo.filter.ErrorFilter;
import com.hcl.railways.demo.filter.PostFilter;
import com.hcl.railways.demo.filter.PreFilter;
import com.hcl.railways.demo.filter.RouteFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableSwagger2
public class UserInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserInfoApplication.class, args);
	}
	

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}