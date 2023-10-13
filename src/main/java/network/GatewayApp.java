package network;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class GatewayApp {
    @Value("${dialogue.url}")
    String dialogueUrl;

    @Value("${network.url}")
    String networkUrl;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/user/**")
                        .uri(networkUrl))
                .route(p -> p
                        .path("/login/**")
                        .uri(networkUrl))
                .route(p -> p
                        .path("/post/**")
                        .uri(networkUrl))
                .route(p -> p
                        .path("/friend/**")
                        .uri(networkUrl))
                .route(p -> p
                        .path("/dialog/**")
                        .uri(dialogueUrl))
                .build();
    }
}
