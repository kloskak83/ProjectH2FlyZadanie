package com.ProjectH2Fly.helpers;

import com.ProjectH2Fly.exceptions.Custom500Exception;
import com.ProjectH2Fly.mapper.MapCurrencyResponsToCurrency;
import com.ProjectH2Fly.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCurrencyInDb {

    @Autowired
    IFetchRateFromNbp<String,String> fetch;

    //Zalezy od Currency, a powinien zelezec od jakies abstrakcji?
    public Currency UpdateCurrency(Currency oldCurrency){
        try {
            var json = fetch.GetRate(oldCurrency.getCurrencyCode());
            MapCurrencyResponsToCurrency map = new MapCurrencyResponsToCurrency();
            return map.Map(json,oldCurrency.getId());
        } catch (Exception ex){
            throw new Custom500Exception();
        }
    }
}
/*
    Update.update();

    public class UpdateItem {
        IUpdater<T> update

    public UpdateItem(IUpdater<T> update) {
        this.update = update;
    }
    public void Update() {
        update.update;
    }

    }

    public interface IUpdater<T> {
        T update(T item);
    }

    public class CurrencyUpdate implements IUpdate<Currency>{


    }


 */