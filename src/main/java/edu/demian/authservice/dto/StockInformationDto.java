package edu.demian.authservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockInformationDto {

    private String symbol;

    private String companyName;

    private BigDecimal latestPrice;

    private double changePercent;

    private String currency;

    private long latestUpdate;

}
