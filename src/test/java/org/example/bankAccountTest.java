package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class bankAccountTest {

    @Test
    public void testDeposit(){
        bankAccount account=new bankAccount(100);
        account.deposit(50);
        assertEquals(150,account.getBalance());
    }

    @Test
    public void testWithdrawSuccess()  {
        bankAccount account=new bankAccount(100);
        account.withdraw(50);
        assertEquals(50,account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds(){
        bankAccount account=new bankAccount(100);
        assertThrows(IllegalArgumentException.class,()->account.withdraw(178));
    }


}
