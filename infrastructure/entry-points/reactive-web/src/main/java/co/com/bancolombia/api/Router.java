package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/all/v2"), handler::getAllSedes)
            .andRoute(GET("/api/v2/{id}"), handler::getSedesById)
            .andRoute(POST("/api/sede/v2"), handler::createSedes)
            .andRoute(PUT("/api/update/v2/{id}"), handler::updateSedes)
            .andRoute(DELETE("/api/delete/v2/{id}"), handler::deleteSedes);
    }
}
