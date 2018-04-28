package test;

import model.Account;
import model.Bank;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static model.StudentAccount.STUDENT_DEBIT_LIMIT;

public class AccountTest {

    private static double DELTA = 0.01;

    private Account acct;
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank("Scotiabank", "Vancouver");
        acct = new Account(bank, "Brian Smith", STUDENT_DEBIT_LIMIT);
    }

    @Test
    public void testGetters() {
        assertEquals(acct.getOwner(), "Brian Smith");
        assertEquals(acct.getSavingsBalance(), 0.0, DELTA);
        assertEquals(acct.getChequingBalance(), 0.0, DELTA);
        assertEquals(acct.getDebitLimit(), STUDENT_DEBIT_LIMIT);
        assertEquals(acct.getBank(), bank);
    }

    @Test
    public void testdepositChequing() {
        assertEquals(acct.getChequingBalance(), 0.0, DELTA);
        acct.depositIntoChequing(100);
        assertFalse(acct.depositIntoChequing(-1));
        assertEquals(acct.getChequingBalance(), 100, DELTA);
    }

    @Test
    public void testdepositSavings() {
        assertEquals(acct.getSavingsBalance(), 0.0, DELTA);
        assertFalse(acct.depositIntoSavings(-1));
        assertTrue(acct.depositIntoSavings(100));
        assertEquals(acct.getSavingsBalance(), 100, DELTA);
    }

    @Test
    public void testdebitPurchase() {
        assertFalse(acct.debitPurchase(100));
        acct.depositIntoChequing(100);
        assertTrue(acct.debitPurchase(10));
        assertEquals(acct.getChequingBalance(), 100 - 10, DELTA);
    }


}
