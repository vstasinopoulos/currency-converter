package com.rationaldata.currencyconverter.repository;

import com.rationaldata.currencyconverter.domain.ExchangeRate;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    // TODO Review performance of queriesls

    Optional<ExchangeRate> findFirstByOrderByCreatedAtDesc();

    List<ExchangeRate> findAllByCreatedAtBetweenOrderByCreatedAtDesc(Instant startDate, Instant endDate); // TODO Implement paging
}
