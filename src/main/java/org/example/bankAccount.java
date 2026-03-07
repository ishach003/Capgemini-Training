package org.example;

public class bankAccount {
    private int balance;
    public bankAccount(int balance){
        this.balance=balance;
    }
    public void deposit(int amount){
        balance+=amount;
        System.out.println(balance);
    }

    public int getBalance() {
        return balance;
    }
        public void withdraw(int amount)  {
        if(amount<=0) {
            throw new IllegalArgumentException("Withdraw account must be positive");
        }
        if(amount>balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance-=amount;
            System.out.println(balance);
    }

}
