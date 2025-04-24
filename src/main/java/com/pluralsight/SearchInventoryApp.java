package com.pluralsight;

public class SearchInventoryApp {
    private final ProductService productService = new ProductService();
    private final Menu menu = new Menu();

    public void start() {
        while (true) {
            var option = menu.showMainMenu();
            switch (option) {
                case 1 -> productService.displayProductInventory();
                case 2 -> productService.findProductById();
                case 3 -> productService.priceRange();
                case 4 -> productService.logProductUserInput();
                case 5 -> {
                    System.out.println("Thank you for using Search Inventory");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
