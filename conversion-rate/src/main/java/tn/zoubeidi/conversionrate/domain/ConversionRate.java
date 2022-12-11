package tn.zoubeidi.conversionrate.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConversionRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Currency currencyFrom;

    private Currency currencyTo;

    @Temporal(TIMESTAMP)
    private Instant validityStartDate;

    @Temporal(TIMESTAMP)
    private Instant validityEndDate;

    private BigDecimal rate;


}
