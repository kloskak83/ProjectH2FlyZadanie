package com.ProjectH2Fly.helpers.modelForJson;

import java.util.List;

public class CurrencyResponse {

    private String table;
    private String currency;
    private String code;
    private List<RateResponse> rates;


    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RateResponse> getRates() {
        return rates;
    }

    public void setRates(List<RateResponse> rates) {
        this.rates = rates;
    }
}
