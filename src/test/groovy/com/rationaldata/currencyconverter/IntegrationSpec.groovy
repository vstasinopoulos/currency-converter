package com.rationaldata.currencyconverter


import com.github.tomakehurst.wiremock.client.WireMock
import io.restassured.RestAssured
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWireMock(port = 0, files = ["classpath:/wiremock"])
abstract class IntegrationSpec extends Specification {

    @LocalServerPort
    protected int port;

    void setup() {
        WireMock.reset()
        WireMock.resetAllRequests()
        RestAssured.port = port
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

}
