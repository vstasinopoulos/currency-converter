package com.rationaldata.currencyconverter.api.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@NoArgsConstructor
public class HistoricalRatesRequest {

    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date startDate;

    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date endDate;
}
