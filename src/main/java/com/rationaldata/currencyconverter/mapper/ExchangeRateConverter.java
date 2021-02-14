package com.rationaldata.currencyconverter.mapper;


import com.rationaldata.currencyconverter.api.dto.ExchangeRateResponse;
import com.rationaldata.currencyconverter.domain.ExchangeRate;
import java.time.ZoneId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateConverter implements Converter<ExchangeRate, ExchangeRateResponse> {

    @Override
    public ExchangeRateResponse convert(ExchangeRate source) {
        return ExchangeRateResponse.builder()
            .fromCurrency(source.getFromCurrency().name())
            .toCurrency(source.getToCurrency().name())
            .rate(source.getRate())
            .dateTime(source.getCreatedAt().atZone(ZoneId.systemDefault()))
            .build();
    }
}
