/*
Develop a Java program for an E-commerce order processing where
some products are initialized through multiple constructors,
users can input some product details manually,
the system computes total order cost dynamically,
applies discount policies based on conditions,
and presents a detailed invoice summarizing the purchase.
*/

import java.util.Scanner;

class Product
{
    String name;
    double price;
    int quantity;

    // Constructor 1: Default product
    Product()
    {
        name = "Unknown Product";
        price = 0.0;
        quantity = 1;
    }

    // Constructor 2: Product with name and price
    Product(String name, double price)
    {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    // Constructor 3: Product with all details
    Product(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate total price
    double getTotalPrice()
    {
        return price * quantity;
    }
}

public class EcommerceOrder
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        double totalAmount = 0;

        System.out.println("=== Welcome to E-Commerce Order System ===");

        System.out.print("Enter number of products to buy: ");
        int n = sc.nextInt();

        Product[] products = new Product[n];

        // Loop to take product details
        for (int i = 0; i < n; i++)
        {
            System.out.println("\nEnter details for Product " + (i + 1));

            sc.nextLine(); // Clear buffer

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            // Using constructor with all details
            products[i] = new Product(name, price, quantity);

            totalAmount += products[i].getTotalPrice();
        }

        // Discount logic
        double discount = 0;

        if (totalAmount >= 5000)
        {
            discount = totalAmount * 0.20; // 20% discount
        }
        else if (totalAmount >= 3000)
        {
            discount = totalAmount * 0.10; // 10% discount
        }

        double finalAmount = totalAmount - discount;

        // Invoice display
        System.out.println("\n========== INVOICE ==========");

        System.out.printf(
                "%-15s %-10s %-10s %-10s\n",
                "Product",
                "Price",
                "Qty",
                "Total"
        );

        for (Product p : products)
        {
            System.out.printf(
                    "%-15s %-10.2f %-10d %-10.2f\n",
                    p.name,
                    p.price,
                    p.quantity,
                    p.getTotalPrice()
            );
        }

        System.out.println("-----------------------------------");

        System.out.println("Total Amount: ₹" + totalAmount);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Payable Amount: ₹" + finalAmount);

        System.out.println("\nThank you for shopping with us!");

        sc.close();
    }
}