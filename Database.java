import java.util.HashMap;
import java.util.Scanner;

public class Database {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> database = new HashMap<String, Double>();

        System.out.println("Welcome.");

        while (true) {
            // More options
            System.out.println("Please choose an option: [n]ew account, [d]isplay balance, [a]dd money, [r]emove money, [q]uit:");
            String option = scanner.next();

            if (option.equals("n")) {
                System.out.println("Enter a name and a starting balance, separated by a space:");
                String name = scanner.next();
                double balance = scanner.nextDouble();
                database.put(name, balance);
                System.out.println("New account created for \"" + name + "\" with starting balance of $" + String.format("%.2f", balance));
            }
            else if (option.equals("d")) {
                System.out.println("Please enter the name to see the balance:");
                String name = scanner.next();
                if (database.containsKey(name)) {
                    double balance = database.get(name);
                    System.out.println("Balance for \"" + name + "\" is $" + String.format("%.2f", balance));
                }
                else {
                    System.out.println("No account found for \"" + name + "\"");
                }
            }
            else if (option.equals("q")) {
                System.out.println("Thank you.");
                break;
            }
            // Adding money feature
            else if (option.equals("a")) {
                System.out.println("Please enter the name to update the balance:");
                String name = scanner.next();
                if (database.containsKey(name)) {
                    System.out.println("Please enter how much money to add:");
                    double balance = database.get(name);
                    double add = scanner.nextDouble();
                    database.put(name, balance + add);
                    System.out.println("Balance for \"" + name + "\" is now $" + String.format("%.2f", balance + add));
                }
            }
            // Removing money feature
            else if (option.equals("r")) {
                System.out.println("Please enter the name to update the balance:");
                String name = scanner.next();
                if (database.containsKey(name)) {
                    System.out.println("Please enter how much money to remove:");
                    double balance = database.get(name);
                    double remove = scanner.nextDouble();
                    database.put(name, balance - remove);
                    System.out.println("Balance for \"" + name + "\" is now $" + String.format("%.2f", balance - remove));
                }
            }
            else {
                System.out.println("Invalid option.");
            }
        }
    }
}
