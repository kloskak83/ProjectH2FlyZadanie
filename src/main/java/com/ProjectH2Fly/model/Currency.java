package com.ProjectH2Fly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Entity
public class Currency {

    @Id
    private int id;
    private String currencyName;
    private String currencyCode;
    //TODO: poprawic na odpowieny typ dla pieniedzy
    private BigDecimal midRate;

    public Currency(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal  getMidRate() {
        return midRate;
    }

    public void setMidRate(BigDecimal  midRate) {
        this.midRate = midRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

}
