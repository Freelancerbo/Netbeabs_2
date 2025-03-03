
import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for customer information
        System.out.println("Enter customer ID:");
        int customerID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        // Create customer object
        int name = 1;
Customer customer = new Customer(customerID, customerName);

        // Prompt user to add products to shopping cart
        boolean addMoreProducts = true;
        while (addMoreProducts) {
            System.out.println("Enter product ID:");
            int productID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.println("Enter product name:");
            String productName = scanner.nextLine();
            System.out.println("Enter product price:");
            double productPrice = scanner.nextDouble();

            // Create product object and add to customer's shopping cart
            Product product = new Product(productID, productName, productPrice);
            customer.addProductToCart(product);

            // Ask if user wants to add more products
            System.out.println("Do you want to add more products? (yes/no)");
            String addMore = scanner.next();
            addMoreProducts = addMore.equalsIgnoreCase("yes");
        }

        // Display customer information
        System.out.println("===== Customer Information =====");
        System.out.printf("Customer ID: %d%n", customer.getCustomerID());
        System.out.printf("Customer Name: %s%n", customer.getName());
        System.out.println("Shopping Cart:");
        for (Product product : customer.getShoppingCart()) {
            System.out.printf("- %s%n", product);
        }

        // Place an order
        List<Product> cart = customer.getShoppingCart();
        Order order = new Order(1, customer, cart);

        // Display order information
        System.out.println("\n===== Order Information =====");
        System.out.printf("Order ID: %d%n", order.getOrderID());
        System.out.printf("Customer: %s%n", order.getCustomer().getName());
        System.out.println("Ordered Products:");
        for (Product product : order.getProducts()) {
            System.out.printf("- %s%n", product);
        }
        System.out.printf("Order Total: $%.2f%n", order.getOrderTotal());

        // Close scanner
        scanner.close();
    }
}
