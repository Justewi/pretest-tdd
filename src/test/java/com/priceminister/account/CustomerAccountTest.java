package com.priceminister.account;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.*;

import com.priceminister.account.exceptions.IllegalAddingAmountException;
import com.priceminister.account.exceptions.IllegalBalanceException;
import com.priceminister.account.implementation.customer.CustomerAccount;
import com.priceminister.account.implementation.customer.CustomerAccountRule;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertNotEquals(null, customerAccount.getBalance());
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     * 
     * @throws IllegalAddingAmountException
     */
    @Test
    public void testAddPositiveAmount() throws IllegalAddingAmountException {
        BigDecimal addedAmount = new BigDecimal("15.09");
        customerAccount.add(addedAmount, rule);

        BigDecimal expected = customerAccount.getBalance();
        BigDecimal result = addedAmount;

        assertEquals(expected, result);
    }

    /**
     * Adds a negative amount to the account.
     * 
     * @throws IllegalAddingAmountException
     */
    @Test(expected = IllegalAddingAmountException.class)
    public void testAddNegativeAmountIllegalAmount() throws IllegalAddingAmountException {
        BigDecimal addedAmount = new BigDecimal("-15.09");
        
        try {
            customerAccount.add(addedAmount, rule);
        } catch (IllegalAddingAmountException e) {
            throw e;
        }
        finally{
            //We check that balance hasn't been modified
            BigDecimal expected = BigDecimal.ZERO;
            BigDecimal result = customerAccount.getBalance();
            assertEquals(expected, result);
        }    
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception. 
     * 
     * @throws IllegalBalanceException
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
        BigDecimal withdrawnAmount = new BigDecimal("15.09");
        
        try {
            customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);
        } catch (IllegalBalanceException e) {
            throw e;
        }
        finally{
            //We check that balance hasn't been modified
            BigDecimal expected = BigDecimal.ZERO;
            BigDecimal result = customerAccount.getBalance();
            assertEquals(expected, result);
        }
        
    }
    

    /**
     * Tests that a legal withdrawal returns the correct new amount.
     * 
     * @throws IllegalBalanceException
     * @throws IllegalAddingAmountException
     */
    @Test
    public void testWithdrawAndReportBalance() throws IllegalBalanceException, IllegalAddingAmountException {
        BigDecimal withdrawnAmount = new BigDecimal("15.09");
        BigDecimal accountAmount = new BigDecimal("18.09");

        customerAccount.add(accountAmount, rule);

        BigDecimal expected = new BigDecimal("3");
        BigDecimal result = customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);

        //We can't compare bigdecimal using equals since it takes scale in consideration
        assertTrue(expected.compareTo(result) == 0);
    }
    

}
