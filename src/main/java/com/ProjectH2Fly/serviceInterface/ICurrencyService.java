package com.ProjectH2Fly.serviceInterface;

import com.ProjectH2Fly.modelForView.AvailableCurrenciesForView;
import com.ProjectH2Fly.modelForView.ConvertedValueForView;
import com.ProjectH2Fly.modelForView.CurrencyRateForView;
import com.ProjectH2Fly.modelForView.CurrencyToConvertForView;

import java.util.List;

public interface ICurrencyService {

    List<AvailableCurrenciesForView> getAvailableCurrency();
    ConvertedValueForView convertedCurrencies(CurrencyToConvertForView
                                                      currencyToConvert);
    List<CurrencyRateForView> getCurrentRate();
}
