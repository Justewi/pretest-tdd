package com.priceminister.account;

import java.math.BigDecimal;

import com.priceminister.account.exceptions.IllegalAddingAmountException;
import com.priceminister.account.exceptions.IllegalBalanceException;

/**
 * This class represents a simple account. It doesn't handle different
 * currencies, all money is supposed to be of standard currency EUR.
 * 
 * Note: I consider that an account cannot be and admin/vendor and so on since the
 * exercice is only about balances etc... 
 * 
 * Here, I would have requested a Business Analyst / Product Owner assistance to know if
 * the account could be an admin in the future. But here I am alone so I decide to
 * think the code so that he can handle this easily but I wont implement it yet. 
 * 
 * I learned with experience that there is no point in preparing complex patterns and architecture
 * to facilitate an upgrade that will probably never happen. (YAGNI)
 * 
 * If an accounts could be admin's (or vendor), I would have taken away all
 * methods relative to balances since admin account most likely doesnt need those.
 * Plus, I would have also most likely made Account an abstract class containing common infos
 * (such as email, password etc.) and methods (login etc.)
 * 
 * Making Account an interface makes it possible to have a contract for different types of customer accounts (such as
 * a premium customer that can withdraw more money that he has on his account eg.)
 * 
 */
public interface Account {

    /**
     * Adds money to this account.
     * @param addedAmount - the money to add
     * @throws IllegalAddingAmountException
     */
    public void add(BigDecimal addedAmount, AccountRule rule) throws IllegalAddingAmountException;
    
    /**
     * Withdraws money from the account.
     * @param withdrawnAmount - the money to withdraw
     * @param rule - the AccountRule that defines which balance is allowed for this account
     * @return the remaining account balance
     * @throws IllegalBalanceException if the withdrawal leaves the account with a forbidden balance
     */
    public BigDecimal withdrawAndReportBalance(BigDecimal withdrawnAmount, AccountRule rule) throws IllegalBalanceException;
    
    /**
     * Gets the current account balance.
     * @return the account's balance
     */
    public BigDecimal getBalance();

    
    
    

    
    
    
}
