package lt.code.academy.data;

import lt.code.academy.data.User;
import org.bson.types.ObjectId;

import java.util.List;

public class Bank {
    private ObjectId id;
    private String bankName;
    private List<User> users;

    public Bank(ObjectId id, String bankName, List<User> users) {
        this.id = id;
        this.bankName = bankName;
        this.users = users;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", users=" + users +
                '}';
    }
}
