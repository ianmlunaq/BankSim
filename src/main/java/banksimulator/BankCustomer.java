package banksimulator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankCustomer { //TODO implement ability for BankCustomer to have many Accounts
    private int customerID;
    private int balanceCents;
    private String fullName;
    private String email;
    private AccountType accountType;

    public BankCustomer(String fullName, String email, AccountType accountType, int uniqueID) {
        customerID = uniqueID;
        balanceCents = 0;
        this.fullName = fullName;
        this.email = email;
        this.accountType = accountType;
    }

    @JsonCreator
    public BankCustomer(@JsonProperty("customerID") int customerID,
                        @JsonProperty("balanceCents") int balanceCents,
                        @JsonProperty("fullName") String fullName,
                        @JsonProperty("email") String email,
                        @JsonProperty("accountType") AccountType accountType,
                        @JsonProperty("accountTypeString") String accountTypeString) {
        this.customerID = customerID;
        this.balanceCents = balanceCents;
        this.fullName = fullName;
        this.email = email;
        this.accountType = accountType;
    }

    public void deposit(int depositAmount) {
        this.balanceCents += depositAmount;
    }

    public void withdraw(int withdrawAmount) {
        balanceCents -= withdrawAmount;
    }

    public int calculateInterestEarned() {
        int interestEarned = (int) (balanceCents * (accountType.getInterestRatePercent()));
        balanceCents += interestEarned;
        return interestEarned;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getBalanceCents() {
        return balanceCents;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getAccountTypeString() {
        return accountType.getAccountTypeString();
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "customerID=" + getCustomerID() +
                ", balance=" + getBalanceCents() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", accountType=" + getAccountType() +
                '}';
    }
}