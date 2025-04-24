package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("[1] List all products");
        System.out.println("[2] Lookup a product by its id");
        System.out.println("[3] Find all products within a price range");
        System.out.println("[4] Add a new product");
        System.out.println("[5] Quit the application");
        return getIntInput();
    }

    public int getIntInput() {
        while (true) {
            try {
                System.out.print("Enter command: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Invalid input. Please enter a valid number. Try again.");
                System.out.println();
            }
        }
    }
}

