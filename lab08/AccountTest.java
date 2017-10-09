import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stephanieclaudinodaffara on 6/30/17.
 */
public class AccountTest {

    private int balance = 10;

    @org.junit.Test
    public void testInit(){
        Account a = new Account(balance);
        assertTrue(a.getBalance()  == balance);
    }

    @org.junit.Test
    public void testInvalidArgs(){
        int invalidArg = -10;
        Account a = new Account(balance);
        a.deposit(invalidArg);
        assertTrue(a.getBalance()  == balance);
        a.withdraw(invalidArg);
        assertTrue(a.getBalance()  == balance);
    }

    @org.junit.Test
    public void testOverdraft(){
        Account a = new Account(balance);
        a.withdraw(balance+1);
        assertTrue(a.getBalance() == balance);

        Account kathy = new Account(500);
        Account megan = new Account(100, kathy);
        megan.withdraw(50);
        assertTrue(kathy.getBalance() == 500);
        assertTrue(megan.getBalance() == 50);

        Account kathy1 = new Account(500);
        Account megan1 = new Account(100, kathy1);
        megan1.withdraw(200);
        assertTrue(kathy1.getBalance() == 400);
        assertTrue(megan1.getBalance() == 0);

        Account kathy2 = new Account(500);
        Account megan2 = new Account(100, kathy2);
        megan2.withdraw(700);
        assertTrue(kathy2.getBalance() == 500);
        assertTrue(megan2.getBalance() == 100);

    }

    @org.junit.Test
    public void deposit() throws Exception {
        Account a = new Account(balance);
        a.deposit(balance);
        assertTrue(a.getBalance() == 2*balance);

    }

    @Test
    public void withdraw() throws Exception {
        Account a = new Account(balance);
        a.withdraw(1);
        assertTrue(a.getBalance() == balance-1);
    }

}