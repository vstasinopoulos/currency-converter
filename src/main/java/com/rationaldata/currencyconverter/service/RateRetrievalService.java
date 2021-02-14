package com.rationaldata.currencyconverter.service;

import com.rationaldata.currencyconverter.domain.ExchangeRate;
import com.rationaldata.currencyconverter.repository.ExchangeRateRepository;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RateRetrievalService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate getLatest() {
        return exchangeRateRepository.findFirstByOrderByCreatedAtDesc()
            .orElseThrow(RuntimeException::new); // TODO Add custom exception for proper error handling
    }

    public List<ExchangeRate> getHistoricalRates(Date startDate, Date endDate) {
        return exchangeRateRepository.findAllByCreatedAtBetweenOrderByCreatedAtDesc(startDate.toInstant(), endDate.toInstant());
    }
}
