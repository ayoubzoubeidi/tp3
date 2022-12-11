package tn.zoubeidi.conversionoperation;

import tn.zoubeidi.conversionoperation.domain.Currency;
import tn.zoubeidi.conversionoperation.domain.Operation;

import java.math.BigDecimal;

public class TestUtils {

    public static Currency FROM = Currency.TND;
    public static Currency TO = Currency.EUR;

    public static BigDecimal RATE = new BigDecimal("2.52");

    public static BigDecimal INITIAL_AMOUNT = new BigDecimal("856.23");

    public static BigDecimal EXPECTED_AMOUNT = INITIAL_AMOUNT.multiply(RATE);

}
