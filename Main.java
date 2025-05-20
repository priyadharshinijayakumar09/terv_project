import java.util.ArrayList;
import java.util.Scanner;

class Property {
    int id;
    String address;
    double price;
    String status; // "Available", "Sold", "Rented"

    Property(int id, String address, double price) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.status = "Available";
    }

    public String toString() {
        return "ID: " + id + ", Address: " + address + ", Price: $" + price + ", Status: " + status;
    }
}

public class Main {
    static ArrayList<Property> properties = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int propertyId = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== Real Estate Management System ====");
            System.out.println("1. Add Property");
            System.out.println("2. View All Properties");
            System.out.println("3. Mark Property as Sold");
            System.out.println("4. Mark Property as Rented");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProperty();
                    break;
                case 2:
                    viewProperties();
                    break;
                case 3:
                    markSold();
                    break;
                case 4:
                    markRented();
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }

    static void addProperty() {
        sc.nextLine(); // clear buffer
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Property p = new Property(propertyId++, address, price);
        properties.add(p);
        System.out.println("Property added successfully!");
    }

    static void viewProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties found.");
        } else {
            System.out.println("\nList of Properties:");
            for (Property p : properties) {
                System.out.println(p);
            }
        }
    }

    static void markSold() {
        System.out.print("Enter Property ID to mark as SOLD: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Property p : properties) {
            if (p.id == id && p.status.equals("Available")) {
                p.status = "Sold";
                System.out.println("Property marked as SOLD.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Property not found or not available.");
        }
    }

    static void markRented() {
        System.out.print("Enter Property ID to mark as RENTED: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Property p : properties) {
            if (p.id == id && p.status.equals("Available")) {
                p.status = "Rented";
                System.out.println("Property marked as RENTED.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Property not found or not available.");
        }
    }
}
