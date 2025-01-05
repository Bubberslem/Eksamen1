package IndkøbsKurven;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();

        ArrayList<Product> products = new ArrayList<>();
        // Add products
        products.add(new Clothes("T-shirt", 49.85, "10", "black"));
        products.add(new Clothes("Pants", 88.00, "8", "brown"));
        products.add(new Electronics("Headset", 100.00, 6));
        products.add(new Electronics("Tablet", 255.00, 24));
        products.add(new Food("Milk", 1.75, "1-6-2025"));

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Clothes");
            System.out.println("2. Show Electronics");
            System.out.println("3. Show Food");
            System.out.println("4. View Basket");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Show clothes
                    System.out.println("\nClothes:");
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i) instanceof Clothes) {
                            System.out.println((i + 1) + ". " + products.get(i));
                        }
                    }
                    System.out.print("Choose a product to add to basket (0 to cancel): ");
                    int clothesChoice = scanner.nextInt();
                    if (clothesChoice > 0 && clothesChoice <= products.size() && products.get(clothesChoice - 1) instanceof Clothes) {
                        basket.addProduct(products.get(clothesChoice - 1));
                        System.out.println("Product added to basket.");
                    }
                    break;

                case 2:
                    // Show electronics
                    System.out.println("\nElectronics:");
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i) instanceof Electronics) {
                            System.out.println((i + 1) + ". " + products.get(i));
                        }
                    }
                    System.out.print("Choose a product to add to basket (0 to cancel): ");
                    int electronicsChoice = scanner.nextInt();
                    if (electronicsChoice > 0 && electronicsChoice <= products.size() && products.get(electronicsChoice - 1) instanceof Electronics) {
                        basket.addProduct(products.get(electronicsChoice - 1));
                        System.out.println("Product added to basket.");
                    }
                    break;

                case 3:
                    // Show food
                    System.out.println("\nFood:");
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i) instanceof Food) {
                            System.out.println((i + 1) + ". " + products.get(i));
                        }
                    }
                    System.out.print("Choose a product to add to basket (0 to cancel): ");
                    int foodChoice = scanner.nextInt();
                    if (foodChoice > 0 && foodChoice <= products.size() && products.get(foodChoice - 1) instanceof Food) {
                        basket.addProduct(products.get(foodChoice - 1));
                        System.out.println("Product added to basket.");
                    }
                    break;

                case 4:
                    // View basket
                    basket.printAll();
                    break;

                case 5:
                    // Exit
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}
