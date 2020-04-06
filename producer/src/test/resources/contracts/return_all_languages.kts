package contracts

import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    request {
        url = url("/languages")
        method = GET
    }
    response {
        status = OK
        body = body(listOf("Java", "Groovy", "Kotlin"))
    }
}
