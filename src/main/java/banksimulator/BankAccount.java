package banksimulator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccount {
    private int accountTypeNum;
    private double interestRatePercent;
    private int balanceCents;

    public BankAccount(int accountTypeNum) {
        this.accountTypeNum = accountTypeNum;
        setInterestRatePercent(accountTypeNum);
        balanceCents = 0;
    }

    @JsonCreator
    public BankAccount(@JsonProperty("accountTypeNum") int accountTypeNum,
                       @JsonProperty("interestRatePercent") double interestRatePercent) {
        this.accountTypeNum = accountTypeNum;
        this.interestRatePercent = interestRatePercent;
    }

    public int getBalanceCents() {
        return balanceCents;
    }

    public double getInterestRatePercent() {
        return interestRatePercent;
    }

    public int getAccountTypeNum() {
        return accountTypeNum;
    }

    @JsonIgnore
    public String getAccountTypeString() {
        String accountTypeString;

        if (accountTypeNum == 1) {
            accountTypeString = "Checking";
        } else {
            accountTypeString = "Savings";
        }

        return accountTypeString;
    }

    public void setAccountTypeNum(int accountTypeNum) {
        this.accountTypeNum = accountTypeNum;
        setInterestRatePercent(accountTypeNum);
    }

    public void setInterestRatePercent(int accountType) {
        switch (accountType) {
            case 1:
                interestRatePercent = 0.01;
                break;
            case 2:
                interestRatePercent = 0.02;
                break;
        }
    }

    public void setInterestRate(double interestRate) {
        this.interestRatePercent = interestRate;
    }

    public void deposit(int depositAmount) {
        balanceCents += depositAmount;
    }

    public void withdraw(int withdrawAmount) {
        balanceCents -= withdrawAmount;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountType=" + accountTypeNum +
                ", interestRate=" + interestRatePercent +
                '}';
    }
}