package com.ProjectH2Fly.helpers;

public interface IFetchRateFromNbp<Tin,Tout> {
    Tout GetRate(Tin currencyCode);
}
