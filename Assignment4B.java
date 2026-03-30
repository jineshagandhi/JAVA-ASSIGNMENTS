package mpj4;

import java.io.*;
import java.util.*;

// User-defined Exceptions
class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) {
        super(msg);
    }
}

class MinimumBalanceException extends Exception {
    MinimumBalanceException(String msg) {
        super(msg);
    }
}

class NegativeAmountException extends Exception {
    NegativeAmountException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// Customer Class
class Customer implements Serializable {
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    void display() {
        System.out.println("CID: " + cid + " Name: " + cname + " Balance: " + amount);
    }
}

// Main Class
public class Assignment4B {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Customer> list = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1: createAccount(); break;
                    case 2: deposit(); break;
                    case 3: withdraw(); break;
                    case 4: display(); break;
                    case 5: saveToFile(); break;
                    case 6: loadFromFile(); break;
                    case 7: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 7);
    }

    static void createAccount() throws Exception {
        System.out.print("Enter CID (1-20): ");
        int cid = sc.nextInt();
        sc.nextLine();

        if (cid < 1 || cid > 20)
            throw new InvalidCIDException("CID must be between 1 and 20");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0)
            throw new NegativeAmountException("Amount must be positive");

        if (amt < 1000)
            throw new MinimumBalanceException("Minimum balance is 1000");

        list.add(new Customer(cid, name, amt));
        System.out.println("Account created!");
    }

    static void deposit() throws Exception {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        for (Customer c : list) {
            if (c.cid == cid) {
                System.out.print("Enter deposit amount: ");
                double amt = sc.nextDouble();

                if (amt <= 0)
                    throw new NegativeAmountException("Amount must be positive");

                c.amount += amt;
                System.out.println("Deposit successful!");
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    static void withdraw() throws Exception {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        for (Customer c : list) {
            if (c.cid == cid) {
                System.out.print("Enter withdraw amount: ");
                double amt = sc.nextDouble();

                if (amt <= 0)
                    throw new NegativeAmountException("Amount must be positive");

                if (amt > c.amount)
                    throw new InsufficientBalanceException("Insufficient balance");

                c.amount -= amt;
                System.out.println("Withdrawal successful!");
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    static void display() {
        for (Customer c : list) {
            c.display();
        }
    }

    static void saveToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bank.dat"));
        oos.writeObject(list);
        oos.close();
        System.out.println("Data saved to file!");
    }

    static void loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bank.dat"));
        list = (ArrayList<Customer>) ois.readObject();
        ois.close();
        System.out.println("Data loaded from file!");
    }
}