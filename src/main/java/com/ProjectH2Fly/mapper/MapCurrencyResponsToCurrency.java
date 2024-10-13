package com.ProjectH2Fly.mapper;

import com.ProjectH2Fly.exceptions.Custom500Exception;
import com.ProjectH2Fly.model.Currency;
import com.ProjectH2Fly.helpers.modelForJson.CurrencyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapCurrencyResponsToCurrency {

    public Currency Map(String json,int currencyId){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CurrencyResponse currencyResponse = objectMapper.readValue(json, CurrencyResponse.class);

            // Generated object form json string
            Currency currency = new Currency();
            currency.setId(currencyId);
            currency.setCurrencyName(currencyResponse.getCurrency());
            currency.setCurrencyCode(currencyResponse.getCode());
            currency.setMidRate(currencyResponse.getRates().get(0).getMid());

            System.out.println("Currency Name: " + currency.getCurrencyName());
            System.out.println("Currency Code: " + currency.getCurrencyCode());
            System.out.println("Mid Rate: " + currency.getMidRate());
            return currency;
        }
        catch (Exception e){
           throw new Custom500Exception();
        }
    }
}
