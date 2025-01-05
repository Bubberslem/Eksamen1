package IndkøbsKurven;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();

        ArrayList<Clothes> clothes = new ArrayList<>();
        ArrayList<Electronics> electronics = new ArrayList<>();
        ArrayList<Food> foods = new ArrayList<>();

        // Add products
        clothes.add(new Clothes("T-shirt", 49.85, "10", "black"));
        clothes.add(new Clothes("Pants", 88.00, "8", "brown"));
        electronics.add(new Electronics("Headset", 100.00, 6));
        electronics.add(new Electronics("Tablet", 255.00, 24));
        foods.add(new Food("Milk", 1.75, "1-6-2025"));

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
                    for (int i = 0; i < clothes.size(); i++) {
                        System.out.println((i + 1) + ". " + clothes.get(i));
                    }
                    System.out.print("Choose a product to add to basket (0 to cancel): ");
                    int clothesChoice = scanner.nextInt();
                    if (clothesChoice > 0 && clothesChoice <= clothes.size()) {
                        basket.addProduct(clothes.get(clothesChoice - 1));
                        System.out.println("Product added to basket.");
                    }
                    break;

                case 2:
                    // Show electronics
                    System.out.println("\nElectronics:");
                    for (int i = 0; i < electronics.size(); i++) {
                        System.out.println((i + 1) + ". " + electronics.get(i));
                    }
                    System.out.print("Choose a product to add to basket (0 to cancel): ");
                    int electronicsChoice = scanner.nextInt();
                    if (electronicsChoice > 0 && electronicsChoice <= electronics.size()) {
                        basket.addProduct(electronics.get(electronicsChoice - 1));
                        System.out.println("Product added to basket.");
                    }
                    break;

                case 3:
                    // Show food
                    System.out.println("\nFood:");
                    for (int i = 0; i < foods.size(); i++) {
                        System.out.println((i + 1) + ". " + foods.get(i));
                    }
                    System.out.print("Choose a product to add to basket (0 to cancel): ");
                    int foodChoice = scanner.nextInt();
                    if (foodChoice > 0 && foodChoice <= foods.size()) {
                        basket.addProduct(foods.get(foodChoice - 1));
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
