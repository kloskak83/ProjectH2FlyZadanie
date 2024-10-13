package com.ProjectH2Fly.controller;

import com.ProjectH2Fly.modelForView.AvailableCurrenciesForView;
import com.ProjectH2Fly.modelForView.ConvertedValueForView;
import com.ProjectH2Fly.modelForView.CurrencyRateForView;
import com.ProjectH2Fly.modelForView.CurrencyToConvertForView;
import com.ProjectH2Fly.serviceInterface.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {

    @Autowired
    ICurrencyService service;

    @GetMapping("/availableCurrencies")
    public @ResponseBody Iterable<AvailableCurrenciesForView> getAllCurrency() {
        return service.getAvailableCurrency();
    }

    @PostMapping("/convertCurrencies")
    public ConvertedValueForView convertCurrencies(@RequestBody CurrencyToConvertForView currencyToConvert) {
        return service.convertedCurrencies(currencyToConvert);
    }

    @GetMapping("/currentRate")
    public @ResponseBody Iterable<CurrencyRateForView> getCurrentRate() {
        return service.getCurrentRate();
    }
}
