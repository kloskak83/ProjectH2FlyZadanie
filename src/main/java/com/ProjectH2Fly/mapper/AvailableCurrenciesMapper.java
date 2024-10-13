package com.ProjectH2Fly.mapper;

import com.ProjectH2Fly.model.Currency;
import com.ProjectH2Fly.modelForView.AvailableCurrenciesForView;
import org.springframework.stereotype.Component;

@Component
public class AvailableCurrenciesMapper implements IMapper<Currency,AvailableCurrenciesForView> {

    @Override
    public AvailableCurrenciesForView map(Currency currency) {
        if (currency == null) {
            return null;
        }
        AvailableCurrenciesForView view = new AvailableCurrenciesForView();
        view.setId(currency.getId());
        view.setCode(currency.getCurrencyCode());

        return view;
    }
}
