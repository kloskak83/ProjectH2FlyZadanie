package com.ProjectH2Fly.service;

import com.ProjectH2Fly.exceptions.Custom400Exception;
import com.ProjectH2Fly.exceptions.Custom500Exception;
import com.ProjectH2Fly.helpers.ICurrencyConverter;
import com.ProjectH2Fly.helpers.UpdateCurrencyInDb;
import com.ProjectH2Fly.mapper.IMapper;
import com.ProjectH2Fly.model.Currency;
import com.ProjectH2Fly.model.Log;
import com.ProjectH2Fly.modelForView.AvailableCurrenciesForView;
import com.ProjectH2Fly.modelForView.ConvertedValueForView;
import com.ProjectH2Fly.modelForView.CurrencyRateForView;
import com.ProjectH2Fly.modelForView.CurrencyToConvertForView;
import com.ProjectH2Fly.repository.ICurrencyRepository;
import com.ProjectH2Fly.serviceInterface.ICurrencyService;
import com.ProjectH2Fly.serviceInterface.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyService implements ICurrencyService {

    @Autowired
    ICurrencyRepository repository;
    @Autowired
    UpdateCurrencyInDb update;
    @Autowired
    ICurrencyConverter<BigDecimal, BigDecimal, BigDecimal> convert;

    @Autowired
    IMapper<Currency, AvailableCurrenciesForView> mapper;
    @Autowired
    IMapper<Currency, CurrencyRateForView> mapperRate;
    @Autowired
    ILogService<Log> logService;


    public List<AvailableCurrenciesForView> getAvailableCurrency() {
        try {
            var listOfCurrency = repository.findAll();

            logService.addLog(new Log(this.getClass().toString()));
            return listOfCurrency.stream()
                    .map(mapper::map)
                    .collect(Collectors.toList());
        } catch (Exception ex)
        {
            throw new Custom500Exception();
        }
    }

    public ConvertedValueForView convertedCurrencies(CurrencyToConvertForView currencyToConvert) {

        try {
            var rateFrom = repository.getReferenceById(currencyToConvert.getIdFromCurrency());
            var rateTo = repository.getReferenceById(currencyToConvert.getIdToCurrency());

            repository.save(update.UpdateCurrency(rateFrom));
            repository.save(update.UpdateCurrency(rateTo));

            System.out.println(rateFrom.getMidRate());
            System.out.println(rateTo.getMidRate());

            var converted = convert.Convert(currencyToConvert.getAmount(), rateFrom.getMidRate(), rateTo.getMidRate());
            ConvertedValueForView convertedValueForView = new ConvertedValueForView();
            convertedValueForView.setConverted(converted);
            logService.addLog(new Log(this.getClass().toString()));
            return convertedValueForView;
        } catch (Exception ex) {
            throw new Custom400Exception();
        }


    }

    public List<CurrencyRateForView> getCurrentRate() {
        var listOfCurrency = repository.findAll();
        listOfCurrency.forEach(item -> repository.save(update.UpdateCurrency(item)));
        logService.addLog(new Log(this.getClass().toString()));
        return listOfCurrency.stream()
                .map(mapperRate::map)
                .collect(Collectors.toList());

    }
}

