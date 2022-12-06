package tn.zoubeidi.conversionoperation.service;

import tn.zoubeidi.conversionoperation.domain.Currency;
import tn.zoubeidi.conversionoperation.domain.Operation;

import java.math.BigDecimal;

public interface OperationService {

    Operation convert(Currency from, Currency to, BigDecimal amount);

}
