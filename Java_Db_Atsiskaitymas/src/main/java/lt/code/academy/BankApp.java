package lt.code.academy;

import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.client.MongoObjectClienntProvider;
import lt.code.academy.data.Bank;
import lt.code.academy.data.BillingAccount;
import lt.code.academy.data.User;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class BankApp {

    private static MongoCollection<User> userCollection;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankApp bankApp = new BankApp();

        MongoClient client = MongoObjectClienntProvider.getClient();
        MongoDatabase database = client.getDatabase("Bank");

        userCollection = database.getCollection("user", User.class);


        String action;
        do {
            bankApp.menu();
            action = sc.nextLine();
            bankApp.userSelection(sc, action);
        } while (!action.equals("5"));
    }

    private void userRegistration(Scanner sc) {
        List<User> users = new ArrayList<>();
        User user;

        do {
            System.out.println("Prasome pateikti savo varda");
            String name = sc.nextLine();

            System.out.println("Prasome pateikti savo pavarde");
            String surname = sc.nextLine();
            System.out.println("Prasome pateikti savo email");
            String email = sc.nextLine();
            System.out.println("Iveskite norima accoutNumber");
            String accountnumber = sc.nextLine();
            System.out.println("test");

            user = userCollection.find(and(eq("email", email), eq("accountNumber", accountnumber))).first();

            if (user != null) {
                System.out.println("toks email arba accountnumber jau paiimti pandykite dar karta");
            } else {
                System.out.println("Sekmingai prisiregistravote , kiek noretumete ideti pinigu kaip pradini inasa");
                double money = sc.nextDouble();
                users.add(new User(null, name, surname, email, accountnumber, new BillingAccount(money)));
                userCollection.insertMany(users);

            }

        } while (user != null);


    }

    private void userLogin(Scanner sc) {
        User user;

        System.out.println("Iveskite savo email");
        String email = sc.nextLine();

        System.out.println("Iveskite savo bankAccount");
        String bankAccount = sc.nextLine();

        user = userCollection.find(and(eq("email", email), eq("accountNumber", bankAccount))).first();

        if (user == null) {
            System.out.println("tokio vartotojo nera prasome prisiregistruoti");
        }
        System.out.println("Sekmingai prisijungete");


    }

    private void userSelection(Scanner sc, String action) {
        switch (action) {
            case "1" -> userRegistration(sc);
            case "2" -> userLogin(sc);
            case "3" -> System.out.println("3");
            case "4" -> System.out.println("4");
            case "5" -> System.out.println("Programa baigia darba");
            default -> System.out.println("Tokio veiksmo nera");
        }
    }

    private void menu() {
        System.out.println("""
                1. Prisiregistruoti
                2. Prisijunkti
                3. Patikrinti balance
                4. Pervesti pinigus
                5. Iseiti
                """);
    }
}
