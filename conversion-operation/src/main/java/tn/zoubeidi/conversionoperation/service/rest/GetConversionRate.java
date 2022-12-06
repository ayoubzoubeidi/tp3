package tn.zoubeidi.conversionoperation.service.rest;

import tn.zoubeidi.conversionoperation.domain.Currency;

import java.math.BigDecimal;

public interface GetConversionRate {
    BigDecimal getConversionRate(Currency from, Currency to);
}
