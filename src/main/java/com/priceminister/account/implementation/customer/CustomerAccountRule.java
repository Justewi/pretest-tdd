/*
 * =============================================================================
 *
 *   PRICE MINISTER APPLICATION
 *   Copyright (c) 2000 Babelstore.
 *   All Rights Reserved.
 *
 *   $Source$
 *   $Revision$
 *   $Date$
 *   $Author$
 *
 * =============================================================================
 */
package com.priceminister.account.implementation.customer;

import java.math.BigDecimal;

import com.priceminister.account.AccountRule;


public class CustomerAccountRule implements AccountRule {

    /* (non-Javadoc)
     * @see com.priceminister.account.AccountRule#withdrawPermitted(java.lang.BigDecimal)
     */
    public boolean withdrawPermitted(BigDecimal resultingAccountBalance) {
        return resultingAccountBalance.compareTo(BigDecimal.ZERO) >= 0;
    }

    public boolean addPermitted(BigDecimal addedAmount) {
        return addedAmount.compareTo(BigDecimal.ZERO) < 0;
    }

}
