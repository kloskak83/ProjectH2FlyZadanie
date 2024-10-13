package com.ProjectH2Fly.mapper;

import com.ProjectH2Fly.model.Currency;
import com.ProjectH2Fly.modelForView.CurrencyRateForView;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRateForViewMapper implements IMapper<Currency, CurrencyRateForView> {
    @Override
    public CurrencyRateForView map(Currency currency){
        if(currency == null){
            return null;
        }
        CurrencyRateForView view = new CurrencyRateForView();
        view.setCurrencyCode(currency.getCurrencyCode());
        view.setMidRate(currency.getMidRate());
        view.setCurrencyName(currency.getCurrencyName());

        return view;
    }
}
