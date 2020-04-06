package com.example.producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.json
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux

@SpringBootApplication
class ProducerApplication

fun main(args: Array<String>) {
	runApplication<ProducerApplication>(*args)
}

@Bean
fun apiRouter() = router {
    (accept(MediaType.APPLICATION_JSON) and "/languages").nest {
        GET("/") { request -> ok().json().body(Flux.just("Java", "Groovy", "Kotlin"), List::class.java) }
    }
}
