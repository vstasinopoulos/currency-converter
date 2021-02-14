package com.rationaldata.currencyconverter.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrencyConverterErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("Could not convert currency. Response status {} and body: {}", response.status(), response.body());
        throw new RuntimeException(); // TODO Add custom exception and proper error handling
    }
}
