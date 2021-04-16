package com.kasperx.mazebank.desktop;

/**
 * @author Kasper Sergeievic
 * @version 0.1.0
 * @date 2020-04-16
 * @description model for credit account
 */
public class CreditAccount extends Account{
    private double overdraftLimit;

    public CreditAccount(long accountNo, String password, int checksum, String availableDateTime, int userProfileId) {
        super(accountNo, password, checksum, availableDateTime, userProfileId);
        this.overdraftLimit = -2000.0;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount){
        if(getBalance() - amount >= overdraftLimit){
            return super.setBalance(getBalance() - amount);
        }
        return false;
    }
}
