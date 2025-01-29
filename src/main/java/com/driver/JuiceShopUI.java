package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JuiceShopUI {
    private static List<JuiceDTO> juiceList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addJuice(scanner);
                    break;
                case 2:
                    displaySummary();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void printMenu() {
        //your code goes here
        System.out.println("\n=== Juice Shop Menu ===");
        System.out.println("1. Add a new juice");
        System.out.println("2. Display juice summary");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addJuice(Scanner scanner) {
        //your code goes here
        System.out.print("Enter juice name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ingredients (comma-separated): ");
        String ingredientsInput = scanner.nextLine();
        List<String> ingredients = Arrays.asList(ingredientsInput.split("\\s*,\\s*"));

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        JuiceDTO juice = new JuiceDTO(name, ingredients, price);
        juiceList.add(juice);
        System.out.println("Juice added successfully!");

    }

    private static void displaySummary() {
        //your code goes here
        if (juiceList.isEmpty()) {
            System.out.println("No juices available.");
            return;
        }

        System.out.println("\nJuice Details:");
        System.out.println("Name\tIngredients\tPrice");
        for (JuiceDTO juice : juiceList) {
            System.out.println(juice);
        }
    }
}

