package com.distributed.microservice.currencyexchangeservice.repository;

import com.distributed.microservice.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;
import java.util.Optional;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {

    Optional<ExchangeValue> findByFromRateAndToRate(String from, String to);

}
