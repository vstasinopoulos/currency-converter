package com.rationaldata.currencyconverter.api.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateResponse {

    private String fromCurrency;

    private String toCurrency;

    private BigDecimal rate;

    private ZonedDateTime dateTime;
}
