package tn.zoubeidi.conversionoperation.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.zoubeidi.conversionoperation.domain.Currency;
import tn.zoubeidi.conversionoperation.domain.Operation;
import tn.zoubeidi.conversionoperation.repository.OperationRepository;
import tn.zoubeidi.conversionoperation.service.rest.GetConversionRate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;
    private final GetConversionRate getConversionRate;
    @Override
    @Transactional
    public Operation convert(Currency from, Currency to, BigDecimal amount) {
        Operation operation = new Operation();
        operation.setCurrencyFrom(from);
        operation.setCurrencyTo(to);
        operation.setInitialAmount(amount);
        BigDecimal conversionRate = getConversionRate.getConversionRate(from, to);
        operation.setConversionRate(conversionRate);
        operation.setConvertedAmount(amount.multiply(conversionRate));
        return operationRepository.saveAndFlush(operation);
    }
}
