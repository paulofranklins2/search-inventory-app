package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static com.pluralsight.Menu.scanner;


public class ProductService {
    private static final String FILE_PATH = "src/main/resources/inventory.csv";

    private void logProduct(Product product) {

        try (var fileWriter = new FileWriter(FILE_PATH, true)) {
            fileWriter.write(product.getId() + "|" + product.getName() + "|" + product.getPrice() + "\n");
        } catch (IOException e) {
            System.err.println("Error saving product: " + e.getMessage());
        }
    }

    public void logProductUserInput() {
        int inputProductId = 0;
        String inputProductName = "";
        float inputProductPrice = 0.0f;

        scanner.nextLine();

        while (true) {
            try {
                System.out.print("Input product id: ");
                inputProductId = Integer.parseInt(scanner.nextLine());

                System.out.print("Input product name: ");
                inputProductName = scanner.nextLine();

                System.out.print("Input product price: ");
                inputProductPrice = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter the correct data types.");
                System.out.println();
            }
        }
        var newProduct = new Product(inputProductId, inputProductName, inputProductPrice);
        logProduct(newProduct);
    }

    public ArrayList<Product> displayProductInventory() {
        var arrayList = new ArrayList<Product>();
        try (var bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            String[] splitBy;
            while ((line = bufferedReader.readLine()) != null) {
                splitBy = line.split("\\|");
                arrayList.add(new Product(Integer.parseInt(splitBy[0]), splitBy[1], Float.parseFloat(splitBy[2])));
            }
        } catch (IOException e) {
            System.err.println("Error reading inventory list: " + e.getMessage());
        }
        return arrayList;
    }

    public void findProductById() {
        int productId = 0;
        while (true) {
            try {
                System.out.print("Find product by id: ");
                productId = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter valid product id.");
                System.out.println();
            }
        }

        var found = false;
        for (int i = 0; i < displayProductInventory().size(); i++) {
            Product product = displayProductInventory().get(i);
            if (product.getId() == productId) {
                System.out.println("Product found: ID:" + product.getId() + " | name: " + product.getName() + " | price: " + product.getPrice());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product ID: " + productId + " not found");
        }
    }

    public void priceRange() {
        float startingPrice;
        float endingPrice;
        var found = false;
        while (true) {
            try {
                System.out.print("Enter starting price range: ");
                startingPrice = scanner.nextFloat();
                System.out.print("Enter ending price range: ");
                endingPrice = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter valid price");
            }
        }


        for (int i = 0; i < displayProductInventory().size(); i++) {
            Product product = displayProductInventory().get(i);
            if (product.getPrice() > startingPrice && product.getPrice() < endingPrice) {
                System.out.println("Product found: ID:" + product.getId() + " | name: " + product.getName() + " | price: " + product.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product in the price range from: " + startingPrice + " to: " + endingPrice + " were found");
        }
    }
}
