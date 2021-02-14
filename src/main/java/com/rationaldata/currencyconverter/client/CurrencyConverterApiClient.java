package com.rationaldata.currencyconverter.client;

import com.rationaldata.currencyconverter.config.CurrencyConverterFeignConfig;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currencyConverterApiClient", url = "${clients.currencyConverter.baseUrl:https://free.currconv.com}", configuration = CurrencyConverterFeignConfig.class, decode404 = true)
public interface CurrencyConverterApiClient {

    @RequestMapping(value = "/api/v7/convert", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<Map<String, Double>> convert(@RequestParam(value = "q") String query);
}
