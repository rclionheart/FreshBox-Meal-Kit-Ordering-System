package com.freshbox;

import com.freshbox.data.SampleDataLoader;
import com.freshbox.exception.InvalidCustomerException;
import com.freshbox.exception.MealKitNotFoundException;
import com.freshbox.model.Customer;
import com.freshbox.model.MealKit;
import com.freshbox.model.Order;
import com.freshbox.service.CatalogService;
import com.freshbox.service.CustomerService;
import com.freshbox.service.OrderService;

import java.util.List;

public class FreshBoxApp {

    private boolean running = true;

    private CatalogService catalogService;
    private CustomerService customerService;
    private OrderService orderService;

    void main() {
        catalogService = new CatalogService();
        customerService = new CustomerService();
        orderService = new OrderService();

        List<MealKit> sampleKits = SampleDataLoader.getSampleMealKits();
        for (MealKit kit : sampleKits) {
            catalogService.addMealKit(kit);
        }

        // LEARNER_TODO: Load sample customers into CustomerService.
        // Steps:
        //   1. Call SampleDataLoader.getSampleCustomers() to get the list
        //   2. Use a for-each loop to iterate through the list
        //   3. Call customerService.addCustomer(customer) for each customer
        //   4. Wrap the addCustomer call in a try-catch for InvalidCustomerException

        // LEARNER_TODO: Load sample orders into OrderService.
        // Steps:
        //   1. Call SampleDataLoader.getSampleOrders(catalogService, customerService)
        //   2. Use a for-each loop to iterate through the list
        //   3. Call orderService.registerOrder(order) for each order

        IO.println("Welcome to FreshBox!");
        IO.println("Your meal kit order management system.\n");
        IO.println("Loaded " + catalogService.size() + " meal kits, " +
                   customerService.size() + " customers, and " +
                   orderService.size() + " sample orders.\n");

        while (running) {
            displayMenu();
            int choice = getMenuChoice();
            handleMenuChoice(choice);
        }

        IO.println("\nThank you for using FreshBox. Goodbye!");
    }

    private void displayMenu() {
        String menu = """

            === FreshBox Meal Kit Service ===
            1. Browse Meal Kits
            2. Search Meal Kits
            3. View Customers
            4. Create Customer
            5. Place Order
            6. View Order History
            7. Cancel Order
            8. Exit
            """;
        IO.println(menu);
    }

    private int getMenuChoice() {
        IO.print("Enter choice: ");
        String input = IO.readln();

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void handleMenuChoice(int choice) {
        // LEARNER_TODO: Add cases 2-7 to wire up the remaining handler methods.
        // Case 3 (handleViewCustomers) is provided complete as a reference pattern.
        // Implement the handler method bodies for cases 2, 4, 5, 6, and 7.
        switch (choice) {
            case 1 -> handleBrowseMealKits();
            case 8 -> handleExit();
            default -> IO.println("Invalid choice. Please enter a number between 1 and 8.");
        };
    }

    private void handleBrowseMealKits() {
        IO.println("\n=== Available Meal Kits ===");

        List<MealKit> mealKits = catalogService.getAllMealKits();

        if (mealKits.isEmpty()) {
            IO.println("No meal kits available.");
            return;
        }

        int itemNumber = 1;

        for (MealKit kit : mealKits) {
            IO.println(itemNumber + ". " + kit.toDisplayString());
            itemNumber++;
        }

        IO.println();

        IO.print("Enter meal kit ID for details (or 0 to return to menu): ");
        String input = IO.readln().trim();

        int requestedId;
        try {
            requestedId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            IO.println("Invalid input. Please enter a number.");
            return;
        }

        if (requestedId == 0) {
            return;
        }

        try {
            MealKit selectedKit = catalogService.getMealKit(requestedId);

            displayMealKitDetails(selectedKit);

        } catch (MealKitNotFoundException e) {
            IO.println("\nError: " + e.getMessage());
            IO.println("Please check the ID and try again.");
        }

        IO.println();
    }

    private void displayMealKitDetails(MealKit kit) {
        IO.println("\n╔══════════════════════════════════════════════════════════════╗");
        IO.println("║  MEAL KIT DETAILS                                            ║");
        IO.println("╚══════════════════════════════════════════════════════════════╝");

        IO.println("\n  ID:          " + kit.getId());
        IO.println("  Name:        " + kit.getName());
        IO.println("  Type:        " + kit.getClass().getSimpleName());
        IO.println("  Description: " + kit.getDescription());

        IO.println("\n  Base Price:  $" + String.format("%.2f", kit.getBasePrice()));
        IO.println("  Final Price: $" + String.format("%.2f", kit.calculatePrice()));

        IO.println("  Servings:    " + kit.getDefaultServings());

        String stockStatus = kit.isInStock()
                ? kit.getStockQuantity() + " units available"
                : "OUT OF STOCK";
        IO.println("  Stock:       " + stockStatus);

        if (kit.getRecipe() != null) {
            IO.println("\n  --- Recipe: " + kit.getRecipe().getTitle() + " ---");
            IO.println("  Difficulty:  " + kit.getRecipe().getDifficulty());
            IO.println("  Prep Time:   " + kit.getRecipe().getPrepTimeMinutes() + " min");
            IO.println("  Cook Time:   " + kit.getRecipe().getCookTimeMinutes() + " min");
        }

        if (kit.getIngredients() != null && !kit.getIngredients().isEmpty()) {
            IO.println("\n  --- Ingredients ---");
            for (var ingredient : kit.getIngredients()) {
                IO.println("  • " + ingredient.getName() + " (" + ingredient.getQuantity() + ")");
            }
        }
    }

    // LEARNER_TODO: Implement handleSearchMealKits() to search meal kits by name.
    // This method should:
    //   1. Prompt the user for a search term
    //   2. Ask if they want to show only in-stock items
    //   3. Call the appropriate catalogService.search() overload
    //   4. Display the results
    //   5. Allow the user to view details of a specific kit
    private void handleSearchMealKits() {
        IO.println("\n[Not yet implemented] Search Meal Kits");
    }

    // This method is provided complete as a reference. Wire it up in handleMenuChoice!
    private void handleViewCustomers() {
        IO.println("\n=== Registered Customers ===");

        List<Customer> customers = customerService.getAllCustomers();

        if (customers.isEmpty()) {
            IO.println("No customers registered yet.");
            return;
        }

        int customerNumber = 1;

        for (Customer customer : customers) {
            IO.println(customerNumber + ". " + customer.toDisplayString());
            customerNumber++;
        }

        IO.println();

        IO.print("Enter customer ID for details (or 0 to return to menu): ");
        String input = IO.readln().trim();

        int requestedId;
        try {
            requestedId = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            IO.println("Invalid input. Please enter a number.");
            return;
        }

        if (requestedId == 0) {
            return;
        }

        try {
            Customer selectedCustomer = customerService.getCustomer(requestedId);

            displayCustomerDetails(selectedCustomer);

        } catch (InvalidCustomerException e) {
            IO.println("\nError: " + e.getMessage());
            IO.println("Please check the ID and try again.");
        }

        IO.println();
    }

    private void displayCustomerDetails(Customer customer) {
        IO.println("\n╔══════════════════════════════════════════════════════════════╗");
        IO.println("║  CUSTOMER DETAILS                                            ║");
        IO.println("╚══════════════════════════════════════════════════════════════╝");

        IO.println("\n  ID:    " + customer.getId());
        IO.println("  Name:  " + customer.getName());

        String emailDisplay = (customer.getEmail() == null || customer.getEmail().isBlank())
                ? "(no email on file)"
                : customer.getEmail();
        IO.println("  Email: " + emailDisplay);

        List<Order> orders = orderService.getOrdersForCustomer(customer);
        if (orders.isEmpty()) {
            IO.println("\n  Order History: No orders yet");
        } else {
            IO.println("\n  --- Order History (" + orders.size() + " order(s)) ---");
            for (Order order : orders) {
                IO.println("  • " + order.toDisplayString());
            }
        }
    }

    // LEARNER_TODO: Implement handleCreateCustomer() to create a new customer.
    // This method should demonstrate constructor overloading:
    //   - Ask for a name
    //   - Ask if they want to include an email
    //   - If yes: use new Customer(name, email) — the full constructor
    //   - If no: use new Customer(name) — the overloaded constructor
    //   - Call customerService.addCustomer() with try-catch for InvalidCustomerException
    private void handleCreateCustomer() {
        IO.println("\n[Not yet implemented] Create Customer");
    }

    // LEARNER_TODO: Implement handlePlaceOrder() — the complete order workflow.
    // This is the most complex handler. It should:
    //   1. List customers and let user select one
    //   2. Ask for delivery date (days from now)
    //   3. Create the order with orderService.createOrder() (handle InvalidOrderException)
    //   4. Loop: show meal kits, let user add items (handle OutOfStockException)
    //   5. Submit the order with orderService.submitOrder() (handle OutOfStockException)
    //   6. Display the order summary
    private void handlePlaceOrder() {
        IO.println("\n[Not yet implemented] Place Order");
    }

    // LEARNER_TODO: Implement handleViewOrderHistory() to show orders for a customer.
    // This method should:
    //   1. List customers and let user select one
    //   2. Call orderService.getOrdersForCustomer() to get their orders
    //   3. Display each order using order.toSummary()
    private void handleViewOrderHistory() {
        IO.println("\n[Not yet implemented] View Order History");
    }

    // LEARNER_TODO: Implement handleCancelOrder() to cancel an active order.
    // This method should:
    //   1. List all orders, highlighting ACTIVE ones
    //   2. Let user select an order to cancel
    //   3. Verify the order is ACTIVE (compare with OrderStatus.ACTIVE)
    //   4. Confirm cancellation with the user
    //   5. Call orderService.cancelOrder()
    private void handleCancelOrder() {
        IO.println("\n[Not yet implemented] Cancel Order");
    }

    private void handleExit() {
        running = false;
    }

}
