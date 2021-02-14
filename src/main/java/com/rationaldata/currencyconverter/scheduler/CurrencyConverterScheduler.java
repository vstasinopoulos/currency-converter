package com.rationaldata.currencyconverter.scheduler;

import com.rationaldata.currencyconverter.service.RateChecker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CurrencyConverterScheduler {

    private final RateChecker rateChecker;

    @Scheduled(fixedDelayString = "${scheduler.fixedDelay}")
    public void checkCurrencyExchangeRate() {
        log.info("Checking for currency exchange rate.");
        rateChecker.check();
    }
}
