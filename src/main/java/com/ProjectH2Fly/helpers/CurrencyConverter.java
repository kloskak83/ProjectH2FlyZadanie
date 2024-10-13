package com.ProjectH2Fly.helpers;

import com.ProjectH2Fly.exceptions.Custom400Exception;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CurrencyConverter implements ICurrencyConverter<BigDecimal,BigDecimal,BigDecimal>{
    public BigDecimal Convert(BigDecimal amount,BigDecimal from,BigDecimal to){
        try {
            BigDecimal amountInUSD = amount.multiply(from);
            BigDecimal convertedAmount = amountInUSD.divide(to,10, RoundingMode.HALF_UP);
            return convertedAmount.setScale(2, RoundingMode.HALF_UP);
        }
        catch (Exception ex){
            throw new Custom400Exception();
        }


    }
}
