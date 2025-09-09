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
    private final int customerID;
    private String fullName;
    private String email;
    private String accountTypeString;
    private ArrayList<BankAccount> bankAccounts;

    public static ArrayList<BankCustomer> importFromBackupFile(File customerRecords) throws IOException {
        FileReader fileReader = new FileReader(customerRecords);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<BankCustomer> bankCustomersList = objectMapper.readValue(fileReader, new TypeReference<ArrayList<BankCustomer>>() {});
        return bankCustomersList;
    }

    public BankCustomer(String fullName, String email, BankAccount bankAccount, int uniqueID) {
        customerID = uniqueID;
        this.fullName = fullName;
        this.email = email;
        this.bankAccounts = new ArrayList<>();
        addBankAccount(bankAccount);
    }

    @JsonCreator
    public BankCustomer(@JsonProperty("customerID") int customerID,
                        @JsonProperty("fullName") String fullName,
                        @JsonProperty("email") String email,
                        @JsonProperty("accountTypeString") String accountTypeString) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.email = email;
        this.accountTypeString = accountTypeString;
    }

//    public int calculateInterestEarned() {
//        int interestEarned = (int) (balanceCents * (bankAccount.getInterestRatePercent()));
//        balanceCents += interestEarned;
//        return interestEarned;
//    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public BankAccount getAccount(int bankAccountNum) {
        return bankAccounts.get(bankAccountNum);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "customerID=" + getCustomerID() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}