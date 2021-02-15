package com.rationaldata.currencyconverter.api

import com.rationaldata.currencyconverter.IntegrationSpec
import com.rationaldata.currencyconverter.api.dto.ExchangeRateResponse
import com.rationaldata.currencyconverter.domain.Currency
import org.springframework.http.HttpStatus
import spock.lang.Shared

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.when

class CurrencyConverterControllerSpec extends IntegrationSpec {

    @Shared
    private DateTimeFormatter formatter

    void setupSpec() {
        formatter = DateTimeFormatter.ISO_DATE.withZone(ZoneId.systemDefault())
    }

    def "should get latest rate"() {
        when:
        def response = when().get('v1/rates/latest')

        then:
        response.statusCode == HttpStatus.OK.value()
        with(response.body.as(ExchangeRateResponse)) {
            fromCurrency == Currency.BTC.name()
            toCurrency == Currency.USD.name()
            rate == 48685.11470
        }
    }

    // TODO Add more test for v1/rates/latest, e.g. non happy paths, validations

    def "should get historical rates"() {
        given:
        def now = Instant.now()
        def request = given()
                .queryParam("startDate", formatter.format(now.minusSeconds(24 * 60 * 60)))
                .queryParam("endDate", formatter.format(now.plusSeconds(24 * 60 * 60)))

        when:
        def response = request.when().get('v1/rates')

        then:
        response.statusCode == HttpStatus.OK.value()
        List<ExchangeRateResponse> rates = response.body.as(List)
        rates.size() == 1
        with(rates[0]) {
            fromCurrency == Currency.BTC.name()
            toCurrency == Currency.USD.name()
            rate == 48685.11470
        }

        // FIXME Could be flaky in case schedule job runs after test. Moreover should not depend on default wiremock mappings
    }

    // TODO Add more test for v1/rates, e.g. non happy paths, validations, preload db, etc.

}
