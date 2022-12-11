package tn.zoubeidi.conversionrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.zoubeidi.conversionrate.domain.Currency;
import tn.zoubeidi.conversionrate.repository.ConversionRateRepository;
import tn.zoubeidi.conversionrate.usecases.GetConversionRateUC;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ConversionRateService implements GetConversionRateUC {

    private final ConversionRateRepository conversionRateRepository;

    @Override
    public BigDecimal getCurrentConversionRate(Currency from, Currency to) {
        return conversionRateRepository.findByCurrenciesNow(from, to).orElseThrow(RuntimeException::new);
    }
}
