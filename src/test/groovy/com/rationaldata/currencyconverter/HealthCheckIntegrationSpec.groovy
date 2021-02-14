package com.rationaldata.currencyconverter


import org.springframework.http.HttpStatus

import static io.restassured.RestAssured.when

class HealthCheckIntegrationSpec extends IntegrationSpec {

    def "test context load and health check"() {
        when:
        def response = when().get('actuator/health')

        then:
        response.statusCode == HttpStatus.OK.value()
    }
}
