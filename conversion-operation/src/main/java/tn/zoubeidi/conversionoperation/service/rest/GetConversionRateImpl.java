package tn.zoubeidi.conversionoperation.service.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.zoubeidi.conversionoperation.domain.Currency;

import java.math.BigDecimal;

import static tn.zoubeidi.conversionoperation.service.rest.RestUtil.CONVERSION_API;

@Service
@RequiredArgsConstructor
public class GetConversionRateImpl implements GetConversionRate {

    private final RestTemplate restTemplate;

    @Override
    public BigDecimal getConversionRate(Currency from, Currency to) {
        return restTemplate
                .exchange(CONVERSION_API, HttpMethod.GET, null, BigDecimal.class, from, to).getBody();
    }
}
