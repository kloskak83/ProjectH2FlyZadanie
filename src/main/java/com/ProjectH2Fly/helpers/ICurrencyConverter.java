package com.ProjectH2Fly.helpers;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;


public interface ICurrencyConverter<Tout,Tamount,Trate>  {
    Tout Convert(Tamount amount,Trate from,Trate to);
}

//public interface ICurrencyConverter {
//    BigDecimal Convert(BigDecimal amount,BigDecimal from,BigDecimal to);
//}
