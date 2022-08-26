package com.nttdata.bootcamp.product.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcamp.product.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalErrorHandler implements ErrorWebExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        DataBufferFactory dataBufferFactory = serverWebExchange.getResponse().bufferFactory();
        DataBuffer dataBuffer = null;
        try {
            dataBuffer = dataBufferFactory.wrap(objectMapper
                    .writeValueAsBytes(ApiResponse.failed("Error Message",
                            throwable.getMessage())));
        } catch (JsonProcessingException ex) {
            dataBuffer = dataBufferFactory.wrap(ex.getMessage().getBytes());
        }
        serverWebExchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        serverWebExchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return serverWebExchange.getResponse().writeWith(Mono.just(dataBuffer));
    }

}