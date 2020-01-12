package com.priceminister.account;

import java.math.BigDecimal;

/**
 * Checks if the requested operation is permitted.
 */
public interface AccountRule {
    
    /**
     * Checks if the resulting account balance after a withdrawal is OK
     * for the specific type of account.
     * @param resultingAccountBalance - the amount resulting of the withdrawal
     * @return true if the operation is permitted, false otherwise
     */
    boolean withdrawPermitted(BigDecimal resultingAccountBalance);

    /**
     * Checks if the amount to add is OK
     * for the specific type of account.
     * 
     * Note : Some accounts could be allowed to Add at most 50 euros eg.
     * 
     * @param addedAmount - the added amount
     * @return true if the operation is permitted, false otherwise
     */
    boolean addPermitted(BigDecimal addedAmount);
}
