package com.distributed.microservice.currencyconvertionservice.model;

import java.math.BigDecimal;

public class CurrencyConversion {

    private Long id;
    private String fromRate;
    private String toRate;
    private  BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int port;
    private BigDecimal convertionMultiple;


    public CurrencyConversion() {
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public int getPort() {
        return port;
    }

    public BigDecimal getConvertionMultiple() {
        return convertionMultiple;
    }

    public void setConvertionMultiple(BigDecimal convertionMultiple) {
        this.convertionMultiple = convertionMultiple;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
