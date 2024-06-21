package banksimulator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountType {
    private int accountTypeNum;
    private double interestRatePercent;

    public AccountType(int accountTypeNum) {
        this.accountTypeNum = accountTypeNum;
        setInterestRatePercent(accountTypeNum);
    }

    @JsonCreator
    public AccountType(@JsonProperty("accountTypeNum") int accountTypeNum,
                       @JsonProperty("interestRatePercent") double interestRatePercent)
                       /*@JsonProperty("accountTypeString") String accountTypeString)*/{
        this.accountTypeNum = accountTypeNum;
        this.interestRatePercent = interestRatePercent;
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

    @Override
    public String toString() {
        return "AccountType{" +
                "accountType=" + accountTypeNum +
                ", interestRate=" + interestRatePercent +
                '}';
    }
}