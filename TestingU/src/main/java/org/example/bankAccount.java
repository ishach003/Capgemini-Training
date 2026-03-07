<<<<<<< HEAD
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
=======
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
>>>>>>> ae9c5601946bc87c5ebd0e1003e56754fb6a16c2
