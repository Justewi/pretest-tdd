package com.priceminister.account.implementation.customer;

import java.math.BigDecimal;

import com.priceminister.account.Account;
import com.priceminister.account.AccountRule;
import com.priceminister.account.exceptions.IllegalAddingAmountException;
import com.priceminister.account.exceptions.IllegalBalanceException;


public class CustomerAccount implements Account {

    private BigDecimal balance = BigDecimal.ZERO;
    
    /**
     * Adds money to this account.
     * @param addedAmount - the money to add
     */
    public void add(BigDecimal addedAmount, AccountRule rule) throws IllegalAddingAmountException{
        if(rule.addPermitted(addedAmount)){
            throw new IllegalAddingAmountException(addedAmount);
        }
        this.balance = this.balance.add(addedAmount);
    }

    /**
     * 
     * @param withdrawnAmount - the money to add
     */
    public BigDecimal withdrawAndReportBalance(BigDecimal withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {

        BigDecimal resultingAccountBalance = balance.subtract(withdrawnAmount);

        if(!rule.withdrawPermitted(resultingAccountBalance)){
            throw new IllegalBalanceException(resultingAccountBalance);
        }

        this.setBalance(resultingAccountBalance);

        return resultingAccountBalance;
    }


    

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    

}
