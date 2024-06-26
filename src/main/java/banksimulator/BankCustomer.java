package banksimulator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BankCustomer { //TODO implement ability for BankCustomer to have many Accounts
    private int customerID;
    private int balanceCents;
    private String fullName;
    private String email;
    private AccountType accountType;

    public static ArrayList<BankCustomer> importFromBackupFile(File customerRecords) throws IOException {
        FileReader fileReader = new FileReader(customerRecords);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<BankCustomer> bankCustomersList = objectMapper.readValue(fileReader, new TypeReference<ArrayList<BankCustomer>>() {});
        return bankCustomersList;
    }

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
                        @JsonProperty("accountType") AccountType accountType) {
//                        @JsonProperty("accountTypeString") String accountTypeString) {
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

    @JsonIgnore
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