package Capp;

import java.util.*;


// Checked Exception
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}


// Unchecked Exception
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}



// Account Class
class Account {

    private long accountNumber;
    private long balance;

    public Account(long accountNumber) {
        // initialize fields
        this.accountNumber=accountNumber;
        this.balance=0;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public  void deposit(long amount) throws InvalidAmountException {
        // deposit logic
        if(amount<=0){
            throw new InvalidAmountException("InvalidAmountException");
        }
        balance+=amount;
    }

    public void withdraw(long amount)
            throws InvalidAmountException, InsufficientFundsException {
        // withdraw logic
        if (amount<=0){
            throw new InvalidAmountException("InvalidAmountException");
        }
        if (amount>balance){
            throw new InsufficientFundsException("InsufficientFundsException");
        }
        balance-=amount;
    }
}



// Banking System Class
class BankingSystem {

    private Map<Long, Account> accountMap;

    public BankingSystem() {
        accountMap=new HashMap<>();
        // initialize map
    }

    public void processTransaction(long accountNumber,
                                   String transactionType,
                                   long amount)
            throws InvalidAmountException, InsufficientFundsException {
        // transaction handling logic
        accountMap.putIfAbsent(accountNumber,new Account(accountNumber));
        Account account=accountMap.get(accountNumber);
        if(transactionType.equalsIgnoreCase("deposit")){
            account.deposit(amount);
        } else if (transactionType.equalsIgnoreCase("withdraw")) {
            account.withdraw(amount);
        }

    }

    public List<Account> getSortedAccounts() {
        // sorting logic
        List<Account> accounts=new ArrayList<>(accountMap.values());
        accounts.sort(Comparator.comparing(Account::getBalance).reversed()
                .thenComparing(Comparator.comparing(Account::getAccountNumber)));

        return accounts;
    }
}




// Main Class
public class Enterprise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(" ");

        BankingSystem bankingSystem = new BankingSystem();

        for (int i = 0; i < N; i++) {

            long accountNumber = sc.nextLong();
            String transactionType = sc.next();
            long amount = sc.nextLong();
            // call processTransaction
            try {
                bankingSystem.processTransaction(accountNumber, transactionType, amount);
            } catch (InvalidAmountException e) {

                System.out.println("Exception: InvalidAmountException");

            } catch (InsufficientFundsException e) {

                System.out.println("Exception: InsufficientFundsException");

            }
        }

        // get sorted accounts
        List<Account> accounts = bankingSystem.getSortedAccounts();

        // print accounts
        for (Account acc : accounts) {
            if (acc.getBalance() > 0) {
                System.out.println(acc.getAccountNumber() + " " + acc.getBalance());
            }
        }
        sc.close();

    }

}