package com.rationaldata.currencyconverter.service;

import static com.rationaldata.currencyconverter.util.Utils.extractFromToCurrencyQueryParam;

import com.rationaldata.currencyconverter.client.CurrencyConverterClient;
import com.rationaldata.currencyconverter.domain.Currency;
import com.rationaldata.currencyconverter.domain.ExchangeRate;
import com.rationaldata.currencyconverter.repository.ExchangeRateRepository;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RateChecker {

    private final CurrencyConverterClient currencyConverterClient;
    private final ExchangeRateRepository exchangeRateRepository;

    public void check() {
        BigDecimal rate = currencyConverterClient.convert(extractFromToCurrencyQueryParam(Currency.BTC, Currency.USD));

        ExchangeRate exchangeRate = ExchangeRate.builder()
            .fromCurrency(Currency.BTC)
            .toCurrency(Currency.USD)
            .rate(rate)
            .build();

        exchangeRateRepository.save(exchangeRate);
    }
}
