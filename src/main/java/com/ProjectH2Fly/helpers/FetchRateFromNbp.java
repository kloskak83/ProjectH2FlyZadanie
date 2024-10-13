package com.ProjectH2Fly.helpers;

import com.ProjectH2Fly.exceptions.Custom500Exception;
import com.ProjectH2Fly.model.Log;
import com.ProjectH2Fly.serviceInterface.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FetchRateFromNbp implements IFetchRateFromNbp<String,String> {

    @Autowired
    ILogService<Log> log;
    public String GetRate(String currencyCode){
        try {
            String uri = "https://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode + "/";
            RestTemplate restTemplate = new RestTemplate();
            log.addLog(new Log(this.getClass().toString()));
            return restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
            throw new Custom500Exception();
        }
    }
}
