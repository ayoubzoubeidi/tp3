package tn.zoubeidi.conversionrate.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.zoubeidi.conversionrate.domain.Currency;
import tn.zoubeidi.conversionrate.service.ConversionRateService;

import java.math.BigDecimal;

@Controller
@RequestMapping("/api/v1/conversion")
@RequiredArgsConstructor
public class ConversionRateController {

    private final ConversionRateService conversionRateService;

    @GetMapping("/{from}/{to}/now")
    ResponseEntity<BigDecimal> convertCurrenciesNow(@PathVariable("from") Currency from, @PathVariable("to") Currency to) {
        return new ResponseEntity<>(conversionRateService.getCurrentConversionRate(from, to),
                HttpStatus.OK);
    }

}
