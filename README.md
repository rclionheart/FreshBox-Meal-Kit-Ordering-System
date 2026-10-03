# FreshBox - Meal Kit Order Management System

Welcome to the FreshBox final project! You will be building a console-based meal kit delivery service where users can browse meal kits, manage customers, place orders, and view order history -- all through an interactive command-line menu.

The application skeleton is already in place. Your job is to bring it to life by implementing the core logic. The code compiles and runs right out of the box -- you will see a working menu with some stub behavior. As you complete each task, the app becomes more and more functional until everything works end-to-end.

## Getting Started

### 1. Study the Diagrams

Before you touch any code, take a few minutes to look at the three diagrams in the `diagrams/` folder. They will give you a clear picture of how the system fits together:

- **Architecture Diagram** (`freshbox-architecture.png`) -- Shows the high-level layers and how they interact
- **Class Diagram** (`freshbox-class-diagram.png`) -- Shows all the classes, their fields, methods, and relationships
- **Flowchart** (`freshbox-flowchart.png`) -- Shows the application flow from startup through the interactive menu

Understanding the big picture first will make the implementation tasks much easier.

### 2. Compile and Run

Make sure you have **Java 25** installed and the **Extension Pack for Java** is enabled in VS Code.

Open `FreshBoxApp.java` and click the **Run** button (the play icon) in VS Code to compile and run the application.

You should see the FreshBox interactive menu appear. Some options already work (like viewing customers), while others are waiting for you to implement them.

## Understanding the Code

### LEARNER_TODO Markers

Every place where you need to write code is marked with a `// LEARNER_TODO:` comment. Search your project for these markers to find all the implementation points. Each one includes a description of what to implement and hints to point you in the right direction.

### Reference Examples

Two files are provided as **complete, working reference examples** -- study these before implementing similar classes:

- **`model/VegetarianKit.java`** -- Shows exactly how to extend the `MealKit` base class. Use this as your template when building `FamilyKit` and `PremiumKit`.
- **`service/CustomerService.java`** -- Shows the full service pattern with methods for adding, finding, and retrieving items. Use this as your template when implementing `CatalogService` and `OrderService`.

Additionally, the `handleViewCustomers()` method in `FreshBoxApp.java` is provided complete as a reference for how the other handler methods should work.

## Suggested Task Order

1. Load sample data into services (for-each loops in the main method -- one example is provided for you)
2. Complete the MealKit class hierarchy (FamilyKit, PremiumKit, and MealKit TODO methods)
3. Implement interfaces (toDisplayString, compareTo)
4. Build Customer and Order classes (constructors, calculateTotal, toSummary)
5. Implement service layer methods (CatalogService search, OrderService methods)
6. Create the generic Catalog class
7. Add custom exceptions (OutOfStockException fields, getShortfall)
8. Implement string and date validation (email validation, delivery date checking)
9. Implement interactive menu handlers (wire switch cases 2-7, implement the 5 handler methods)
10. Verify everything works end-to-end

This is a suggested order, but you do not have to follow it strictly. Feel free to work on tasks in whatever order suits you -- the checkpoints in each task help you verify progress.

## Project Structure

```
src/main/java/com/freshbox/
    FreshBoxApp.java     -- Main application entry point and interactive menu
    model/               -- Domain classes (MealKit, Customer, Order, etc.)
    service/             -- Business logic (CatalogService, CustomerService, OrderService)
    exception/           -- Custom exception classes
    util/                -- Generic utility classes (Catalog)
    data/                -- Sample data loader
```

## Tips

- **Start with the diagrams** to understand the big picture before diving into code.
- **Use the reference examples** -- VegetarianKit, CustomerService, and handleViewCustomers show you exactly what finished code looks like. Follow their patterns closely.
- **Compile frequently** to catch errors early. The project is set up so it always compiles, even before you implement anything.
- **Test your changes** by running the app after each task. Seeing your code in action is the best way to know it works.
- **Read the LEARNER_TODO comments carefully** -- they include hints and guidance that point you in the right direction.

Good luck, and have fun building FreshBox!
