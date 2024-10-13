package com.ProjectH2Fly.modelForView;

import java.math.BigDecimal;

public class CurrencyToConvertForView {

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getIdFromCurrency() {
        return IdFromCurrency;
    }

    public void setIdFromCurrency(int idFromCurrency) {
        IdFromCurrency = idFromCurrency;
    }

    public int getIdToCurrency() {
        return IdToCurrency;
    }

    public void setIdToCurrency(int idToCurrency) {
        IdToCurrency = idToCurrency;
    }

    private BigDecimal amount;
    private int IdFromCurrency;
    private int IdToCurrency;
}
