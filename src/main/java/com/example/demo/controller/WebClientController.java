package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 *  fix branch #2
 */

@RestController
public class WebClientController {

    WebClient client;

    @PostConstruct
    void init() {
        client = WebClient.create();
    }

    @GetMapping("/test")
    public Mono<String> doTest() {

        for (int i=0; i<10; i++) {
            callRest().subscribe(x-> {
                System.out.printf("\n x:"+x);
            });
        }
        return callRest();
    }

    private Mono<String> callRest() {
        return client.get()
                .uri("http://192.168.64.2:31450/api2/8")
                .retrieve()
                .bodyToMono(String.class)
                ;
    }


    private Mono<String> callRest2() {
        return client.get()
                .uri("http://192.168.64.2:31450/api2/8")
                .retrieve()
                .bodyToMono(String.class)
                ;
    }
}
