package com.priceminister.account.exceptions;

import java.math.BigDecimal;

public class IllegalAddingAmountException extends Exception {
    
    private static final long serialVersionUID = 2841530912192933146L;

    private BigDecimal amount;
    
    public IllegalAddingAmountException(BigDecimal illegalAmount) {
        amount = illegalAmount;
    }
    
    public String toString() {
        return "Illegal adding amount: " + amount;
    }
}