package com.distributed.microservice.currencyconvertionservice.controller;

import com.distributed.microservice.currencyconvertionservice.model.CurrencyConversion;
import com.distributed.microservice.currencyconvertionservice.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConvertionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy serviceProxy;


    @GetMapping("feign/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> currencyConvertFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {



        ResponseEntity<?> response = serviceProxy.exchangeCurrency(from,to);

        logger.info("{}",response);


        CurrencyConversion currencyConversion = (CurrencyConversion) response.getBody();
        CurrencyConversion currencyConversion2 = new CurrencyConversion();
        currencyConversion2.setId(currencyConversion.getId());
        currencyConversion2.setFromRate(from);
        currencyConversion2.setToRate(to);
        currencyConversion2.setQuantity(quantity);
        currencyConversion2.setConvertionMultiple(currencyConversion.getConvertionMultiple());
        currencyConversion2.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConvertionMultiple()));
        currencyConversion2.setPort(currencyConversion.getPort());


        return new ResponseEntity<>(currencyConversion2,HttpStatus.OK);
    }

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<?> currencyConvert(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
        System.out.println(from);
        System.out.println(to);
        System.out.println(quantity);

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);


        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,uriVariables);

        CurrencyConversion currencyConversion = responseEntity.getBody();

        CurrencyConversion currencyConversion2 = new CurrencyConversion();
        currencyConversion2.setId(currencyConversion.getId());
        currencyConversion2.setFromRate(from);
        currencyConversion2.setToRate(to);
        currencyConversion2.setQuantity(quantity);
        currencyConversion2.setConvertionMultiple(currencyConversion.getConvertionMultiple());
        currencyConversion2.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConvertionMultiple()));
        currencyConversion2.setPort(currencyConversion.getPort());


        return new ResponseEntity<>(currencyConversion2,HttpStatus.OK);
    }
}
