package Capp;

public interface Bank {
    void assignLoans(int[] loans);

    void averageLoan();

    void maxLoan();

    void minLoan();
}

class PersonalLoanDept implements Bank {

    int[] loanAmounts;

    PersonalLoanDept(int clients){
        loanAmounts = new int[clients];
    }


    @Override
    public void assignLoans(int[] loans) {

        // assign loans
        int i=0;
        for(int loan:loans){
            if(i>=loanAmounts.length){
                break;
            }
            loanAmounts[i]=loan;
            i++;
        }
    }

    @Override
    public void averageLoan() {

        // calculate average
        double sum=0;
        for (int l:loanAmounts){
            sum+=l;
        }

        double avg=sum/loanAmounts.length;
        System.out.println(avg);
    }

    @Override
    public void maxLoan() {
        int max=loanAmounts[0];
        // find max loan
        for (int l:loanAmounts){
            if(l>max){
                max=l;
            }
        }

    }

    @Override
    public void minLoan() {

        // find min loan
    }
}

class BusinessLoanDept implements Bank {

    private int[] loans;

    @Override
    public void assignLoans(int[] loans) {

        // assign loans
    }

    @Override
    public void averageLoan() {

        // calculate average
    }

    @Override
    public void maxLoan() {

        // find max loan
    }

    @Override
    public void minLoan() {

        // find min loan
    }
}

