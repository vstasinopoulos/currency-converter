package com.rationaldata.currencyconverter.api;

import com.rationaldata.currencyconverter.api.dto.ExchangeRateResponse;
import com.rationaldata.currencyconverter.api.dto.HistoricalRatesRequest;
import com.rationaldata.currencyconverter.domain.ExchangeRate;
import com.rationaldata.currencyconverter.service.RateRetrievalService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyConverterController {

    private final RateRetrievalService rateRetrievalService;
    private final ConversionService conversionService;

    @GetMapping("v1/rates/latest")
    public ResponseEntity<ExchangeRateResponse> getLatestRate() {
        ExchangeRate rate = rateRetrievalService.getLatest();
        return ResponseEntity.ok(conversionService.convert(rate, ExchangeRateResponse.class));
    }

    @GetMapping("v1/rates")
    public ResponseEntity<List<ExchangeRateResponse>> getHistoricalRates(@Valid HistoricalRatesRequest request) {
        List<ExchangeRate> rates = rateRetrievalService.getHistoricalRates(request.getStartDate(), request.getEndDate());

        return ResponseEntity.ok(rates.stream()
            .map(exchangeRate -> conversionService.convert(exchangeRate, ExchangeRateResponse.class))
            .collect(Collectors.toList()));
    }
}
