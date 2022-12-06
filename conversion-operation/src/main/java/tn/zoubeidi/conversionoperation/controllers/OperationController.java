package tn.zoubeidi.conversionoperation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.zoubeidi.conversionoperation.domain.Currency;
import tn.zoubeidi.conversionoperation.domain.Operation;
import tn.zoubeidi.conversionoperation.service.OperationService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/operation")
@RequiredArgsConstructor
public class OperationController {

    private final OperationService operationService;

    @PostMapping("/{from}/{to}/{amount}")
    Operation createOperation(@PathVariable Currency from, @PathVariable Currency to, @PathVariable BigDecimal amount) {
        return this.operationService.convert(from, to, amount);
    }

}
