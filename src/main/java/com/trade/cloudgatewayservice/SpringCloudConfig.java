package com.trade.cloudgatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(r -> r.path("/transaction/**").uri("lb://TRADE-TRANSACTION-UI-SVC").id("transactionModule"))
				.route(r -> r.path("/dataService/**").uri("lb://TRADE-DATA-SVC").id("dataServiceModule"))
				.route(r -> r.path("/stream-service/**").uri("lb://TRADE-STREAMING-SVC").id("streamModule"))
				.route(r -> r.path("/apiService/**").uri("lb://TRADE-COMP-SVC").id("apiModule")).build();
	}

}
