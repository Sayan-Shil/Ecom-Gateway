package com.ecom.gateway;

import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String s = exchange.getRequest().getHeaders().getFirst("Authorization");
        if(s==null || !s.startsWith("Bearer ")){
            return chain.filter(exchange);
//            exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(HttpStatus.SC_UNAUTHORIZED));
//            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);

    }
}
