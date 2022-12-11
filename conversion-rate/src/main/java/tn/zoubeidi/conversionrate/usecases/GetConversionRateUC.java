package tn.zoubeidi.conversionrate.usecases;

import tn.zoubeidi.conversionrate.domain.Currency;

import java.math.BigDecimal;

public interface GetConversionRateUC {

    BigDecimal getCurrentConversionRate(Currency from, Currency to);

}
