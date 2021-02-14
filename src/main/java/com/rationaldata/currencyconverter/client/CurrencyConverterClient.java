package com.rationaldata.currencyconverter.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CurrencyConverterClient {

    private static final int SCALE = 5;

    private final CurrencyConverterApiClient currencyConverterApiClient;

    public BigDecimal convert(String fromToCurrency) {
        final ResponseEntity<Map<String, Double>> responseEntity = currencyConverterApiClient.convert(fromToCurrency);

        return Optional.ofNullable(responseEntity.getBody())
            .map(m -> m.get(fromToCurrency))
            .map(BigDecimal::valueOf)
            .map(bG -> bG.setScale(SCALE, RoundingMode.HALF_UP))
            .orElseThrow(RuntimeException::new); // TODO Add custom exception for proper error handling
    }
}
