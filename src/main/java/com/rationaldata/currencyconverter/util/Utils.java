package com.rationaldata.currencyconverter.util;

import com.rationaldata.currencyconverter.domain.Currency;

public class Utils {

    private static final String FROM_TO_DELIMITER = "_";

    public static String extractFromToCurrencyQueryParam(Currency fromCurrency, Currency toCurrency) {
        return String.join(FROM_TO_DELIMITER, fromCurrency.name(), toCurrency.name());
    }
}
