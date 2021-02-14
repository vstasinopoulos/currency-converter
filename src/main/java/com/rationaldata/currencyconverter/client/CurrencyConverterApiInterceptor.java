package com.rationaldata.currencyconverter.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CurrencyConverterApiInterceptor implements RequestInterceptor {

    private static final String QUERY_PARAM_COMPACT = "compact";
    private static final String QUERY_PARAM_API_KEY = "apiKey";
    private static final String QUERY_VALUE_ULTRA = "ultra";

    private final String apiKey;

    @Override
    public void apply(RequestTemplate template) {
        template.query(QUERY_PARAM_COMPACT, QUERY_VALUE_ULTRA);
        template.query(QUERY_PARAM_API_KEY, apiKey);
    }
}
