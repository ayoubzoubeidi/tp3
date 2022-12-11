package tn.zoubeidi.conversionrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.zoubeidi.conversionrate.domain.ConversionRate;
import tn.zoubeidi.conversionrate.domain.Currency;

import java.math.BigDecimal;
import java.util.Optional;

public interface ConversionRateRepository extends JpaRepository<ConversionRate, Long> {

    @Query("SELECT cr.rate " +
            "FROM ConversionRate cr " +
            "WHERE cr.currencyFrom = :from AND cr.currencyTo = :to " +
            "AND CURRENT TIMESTAMP BETWEEN cr.validityStartDate  AND cr.validityEndDate")
    Optional<BigDecimal> findByCurrenciesNow(@Param("from") Currency from, @Param("to") Currency to);

}
