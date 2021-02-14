package com.rationaldata.currencyconverter.config;

import com.rationaldata.currencyconverter.client.CurrencyConverterApiInterceptor;
import com.rationaldata.currencyconverter.client.CurrencyConverterErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConverterFeignConfig {

    @Bean
    public CurrencyConverterApiInterceptor currencyConverterApiInterceptor(@Value("${clients.currencyConverter.apiKey}") String apiKey) {
        return new CurrencyConverterApiInterceptor(apiKey);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CurrencyConverterErrorDecoder();
    }
}
