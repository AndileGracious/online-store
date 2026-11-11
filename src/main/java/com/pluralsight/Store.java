package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Starter code for the Online Store workshop.
 * Learners will complete the TODO sections to make the program work.
 * <p>
 * What is already done for you: the two lists, the Home Screen loop and
 * the method headers. Each TODO says what that method has to do.
 * Product.java is complete; products.csv sits at the project root.
 * You will need extra imports (for example java.io.BufferedReader,
 * java.io.FileReader, java.io.IOException) as you fill the TODOs in.
 */
public class Store {

    public static void main(String[] args) {

        // Create lists for inventory and the shopping cart
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        // Load inventory from the data file (pipe-delimited: SKU|Product Name|Price|Department)
        loadInventory("products.csv", inventory);

        // Main menu loop
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("\nWelcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 1, 2, or 3.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> displayProducts(inventory, cart, scanner);
                case 2 -> displayCart(cart, scanner);
                case 3 -> System.out.println("Thank you for shopping with us!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    /** load products.csv into inventory list
     * used while loop to read until end of file
     * parse price to double to turn the text into real number
     */
    public static void loadInventory(String fileName, ArrayList<Product> inventory) {

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String csvLine;
            bufferedReader.readLine();
            while ((csvLine = bufferedReader.readLine())!= null) {
                String[] parts = csvLine.split("\\|");
                String SKU = parts[0];
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                String department = parts[3];

                Product product = new Product(SKU, productName, price, department);
                inventory.add(product);
            }


        } catch (Exception e) {
                System.out.println("Something went wrong!");
        }

    }

    /**
     * Displays all products and lets the user add one to the cart.
     * Typing X returns to the main menu.
     * use for each loop to show each product id, name, price
     * use scanner to prompt user for id
     * use for each loop to find product with matching id
     */
    public static void displayProducts(ArrayList<Product> inventory,
                                       ArrayList<Product> cart,
                                       Scanner scanner) {

        for (Product product : inventory) {
            System.out.println(product.getSKU() + " " + product.getPrice() + " " + product.getProductName());
        }
            System.out.println("Please enter the id for the product you are looking for: ");
            String id = scanner.nextLine();


        for (Product product : inventory) {
            if (product.getSKU().equals(id)) {
                cart.add(product);
            }

        }

    }
    /**
     * Shows the contents of the cart, calculates the total,
     * and offers the option to check out.
     */
    public static void displayCart(ArrayList<Product> cart, Scanner scanner) {
        System.out.println();

        //   • use for each loop to list each product in the cart
        //   • use total payment to compute the total cost
        //   • use scanner ask the user whether to check out (C) or return (X)

        for (Product product : cart) {
            System.out.println(product.getSKU() + " " + product.getPrice() + " " + product.getProductName());

        }
        double totalAmount = totalPayment(cart);
        System.out.println("Your total is: " + totalAmount);
        System.out.println("Choose C to check out or X to return");
        String choice = scanner.nextLine();

        if( choice.equalsIgnoreCase("C")){
            checkOut(cart, totalAmount, scanner);

        } else if(choice.equalsIgnoreCase("X")){
            return;
        }
    }
        public static double totalPayment(ArrayList<Product>cart){
            double total = 0;
            for (Product product : cart) {
                total += product.getPrice();
            }
            return total;
        }
    /**
     * Handles the checkout process:
     * 1. Confirm that the user wants to buy.
     * 2. Accept payment and calculate change.
     * 3. Display a simple receipt.
     * 4. Clear the cart.
     */
    public static void checkOut(ArrayList<Product> cart,
                                double totalAmount,
                                Scanner scanner) {
        // TODO: implement steps listed above
        System.out.println("Total: " + totalAmount);
        System.out.println("Enter payment amount: ");
        double payment = Double.parseDouble(scanner.nextLine());
        double change = payment - totalAmount;
        System.out.println("Your payment is: " + payment);
        System.out.println("your change is: " + change);
        System.out.println("Thank you for shopping with us!");
        cart.clear();
    }

    /**
     * Searches a list for a product by its id.
     *
     * @return the matching Product, or null if not found
     */
    public static Product findProductById(String id, ArrayList<Product> inventory) {
        // TODO: loop over the list and compare ids

        return null;
    }
}

