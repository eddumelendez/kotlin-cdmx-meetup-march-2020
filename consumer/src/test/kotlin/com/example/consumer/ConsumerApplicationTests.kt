package com.example.consumer

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureStubRunner(ids = ["com.example:producer:+:8080"], stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ConsumerApplicationTests {

	@Test
	fun contextLoads() {
		WebTestClient.bindToServer()
		                .build()
		                .get().uri("http://localhost:8080/languages").exchange()
		                .expectStatus().isOk
		                .expectBody().json("""["Java","Groovy","Kotlin"]""")
	}

}
