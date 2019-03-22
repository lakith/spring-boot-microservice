package com.distributed.microservice.currencyexchangeservice.controller;

import com.distributed.microservice.currencyexchangeservice.model.ExchangeValue;
import com.distributed.microservice.currencyexchangeservice.repository.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<?> exchangeCurrency(@PathVariable("from")String from,@PathVariable("to") String to){

        Optional<ExchangeValue> optionalExchangeValue = exchangeValueRepository.findByFromRateAndToRate(from,to);
        if(!optionalExchangeValue.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setId(optionalExchangeValue.get().getId());
        exchangeValue.setFromRate(optionalExchangeValue.get().getFromRate());
        exchangeValue.setToRate(optionalExchangeValue.get().getToRate());
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        exchangeValue.setConvertionMultiple(optionalExchangeValue.get().getConvertionMultiple());

        logger.info("{}",exchangeValue);

        return new ResponseEntity<>(exchangeValue,HttpStatus.OK);
    }
}
