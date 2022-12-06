package tn.zoubeidi.conversionoperation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency currencyFrom;
    @Enumerated(EnumType.STRING)
    private Currency currencyTo;

    private BigDecimal initialAmount;
    private BigDecimal convertedAmount;
    private BigDecimal conversionRate;
}
