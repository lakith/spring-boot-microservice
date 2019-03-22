package com.distributed.microservice.currencyexchangeservice.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "from_rate")
    private String fromRate;
    @Column(name = "to_rate")
    private String toRate;
    private int port;
    private BigDecimal convertionMultiple;


    public ExchangeValue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromRate() {
        return fromRate;
    }

    public void setFromRate(String fromRate) {
        this.fromRate = fromRate;
    }

    public String getToRate() {
        return toRate;
    }

    public void setToRate(String toRate) {
        this.toRate = toRate;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BigDecimal getConvertionMultiple() {
        return convertionMultiple;
    }

    public void setConvertionMultiple(BigDecimal convertionMultiple) {
        this.convertionMultiple = convertionMultiple;
    }
}
