package lt.code.academy.data;

import org.bson.types.ObjectId;

import java.util.List;

public class User {
    private ObjectId id;
    private String name;
    private String surname;
    private String email;
    private String accountNumber;

    private BillingAccount billingAccount;

    public User() {
    }


    public User(ObjectId id, String name, String surname, String email, String accountNumber, BillingAccount billingAccount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.accountNumber = accountNumber;
        this.billingAccount = billingAccount;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", billingAccount=" + billingAccount +
                '}';
    }
}
