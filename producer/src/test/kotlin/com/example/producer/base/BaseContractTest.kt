package com.example.producer.base

import com.example.producer.apiRouter
import io.restassured.module.webtestclient.RestAssuredWebTestClient
import org.junit.jupiter.api.BeforeAll

open class BaseContractTest {

    companion object {

        @BeforeAll
        @JvmStatic
        fun setup() {
            RestAssuredWebTestClient.standaloneSetup(apiRouter())
        }

    }

}
