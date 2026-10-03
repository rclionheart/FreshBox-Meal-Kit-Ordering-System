package com.freshbox.data;

import com.freshbox.model.Customer;
import com.freshbox.model.FamilyKit;
import com.freshbox.model.Ingredient;
import com.freshbox.model.MealKit;
import com.freshbox.model.Order;
import com.freshbox.model.PremiumKit;
import com.freshbox.model.Recipe;
import com.freshbox.model.VegetarianKit;
import com.freshbox.service.CatalogService;
import com.freshbox.service.CustomerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SampleDataLoader {

    public static List<MealKit> getSampleMealKits() {
        List<MealKit> mealKits = new ArrayList<>();

        Recipe vegRecipe1 = new Recipe(
            "Mediterranean Veggie Bowl",
            """
            1. Preheat oven to 400°F (200°C).
            2. Chop bell peppers, zucchini, and eggplant into bite-sized pieces.
            3. Toss vegetables with olive oil, salt, oregano, and garlic.
            4. Spread on baking sheet and roast for 25-30 minutes until golden.
            5. Cook quinoa according to package directions (usually 15 minutes).
            6. Assemble bowls: quinoa base, roasted vegetables on top.
            7. Crumble feta cheese over vegetables.
            8. Drizzle with lemon-herb dressing and serve immediately.
            """,
            15,
            30,
            "Easy"
        );

        List<Ingredient> vegIngredients1 = new ArrayList<>();
        vegIngredients1.add(new Ingredient("Bell Peppers", "2 medium", Set.of()));
        vegIngredients1.add(new Ingredient("Zucchini", "1 large", Set.of()));
        vegIngredients1.add(new Ingredient("Eggplant", "1 medium", Set.of()));
        vegIngredients1.add(new Ingredient("Quinoa", "1 cup", Set.of()));
        vegIngredients1.add(new Ingredient("Feta Cheese", "100g", Set.of("dairy")));
        vegIngredients1.add(new Ingredient("Olive Oil", "3 tbsp", Set.of()));
        vegIngredients1.add(new Ingredient("Lemon-Herb Dressing", "60ml", Set.of()));

        VegetarianKit vegKit1 = new VegetarianKit(
            "Mediterranean Veggie Bowl",
            "Fresh roasted vegetables with fluffy quinoa and tangy feta — a healthy and satisfying meal",
            vegRecipe1,
            vegIngredients1,
            18.99,
            15,
            2
        );
        mealKits.add(vegKit1);

        Recipe vegRecipe2 = new Recipe(
            "Thai Green Curry",
            """
            1. Press tofu to remove excess moisture, then cube into 1-inch pieces.
            2. Heat coconut oil in a large wok or skillet over medium-high heat.
            3. Add green curry paste and stir for 30 seconds until fragrant.
            4. Pour in coconut milk and bring to a gentle simmer.
            5. Add tofu, bamboo shoots, and Thai basil leaves.
            6. Simmer for 15 minutes, stirring occasionally.
            7. Season with soy sauce and a pinch of sugar to balance flavors.
            8. Serve over jasmine rice with lime wedges on the side.
            """,
            20,
            20,
            "Medium"
        );

        List<Ingredient> vegIngredients2 = new ArrayList<>();
        vegIngredients2.add(new Ingredient("Firm Tofu", "400g", Set.of("soy")));
        vegIngredients2.add(new Ingredient("Green Curry Paste", "3 tbsp", Set.of()));
        vegIngredients2.add(new Ingredient("Coconut Milk", "400ml", Set.of()));
        vegIngredients2.add(new Ingredient("Bamboo Shoots", "200g", Set.of()));
        vegIngredients2.add(new Ingredient("Thai Basil", "1 bunch", Set.of()));
        vegIngredients2.add(new Ingredient("Jasmine Rice", "300g", Set.of()));
        vegIngredients2.add(new Ingredient("Soy Sauce", "2 tbsp", Set.of("soy", "gluten")));

        VegetarianKit vegKit2 = new VegetarianKit(
            "Thai Green Curry",
            "Aromatic coconut curry with crispy tofu and fresh Thai basil — authentic Thai flavors at home",
            vegRecipe2,
            vegIngredients2,
            21.99,
            12,
            2
        );
        mealKits.add(vegKit2);

        Recipe vegRecipe3 = new Recipe(
            "Thai Basil Stir-Fry",
            """
            1. Press tofu and cut into cubes.
            2. Heat vegetable oil in a wok over high heat.
            3. Add tofu and fry until golden on all sides.
            4. Add garlic, chili, and green beans; stir-fry for 2 minutes.
            5. Pour in soy sauce and a pinch of sugar.
            6. Toss in Thai basil leaves and stir until wilted.
            7. Serve over steamed jasmine rice.
            """,
            10,
            15,
            "Easy"
        );

        List<Ingredient> vegIngredients3 = new ArrayList<>();
        vegIngredients3.add(new Ingredient("Firm Tofu", "400g", Set.of("soy")));
        vegIngredients3.add(new Ingredient("Thai Basil", "1 bunch", Set.of()));
        vegIngredients3.add(new Ingredient("Green Beans", "200g", Set.of()));
        vegIngredients3.add(new Ingredient("Garlic", "4 cloves", Set.of()));
        vegIngredients3.add(new Ingredient("Soy Sauce", "2 tbsp", Set.of("soy", "gluten")));
        vegIngredients3.add(new Ingredient("Jasmine Rice", "300g", Set.of()));

        VegetarianKit vegKit3 = new VegetarianKit(
            "Thai Basil Stir-Fry",
            "Quick and fragrant tofu stir-fry with fresh Thai basil and crisp green beans",
            vegRecipe3,
            vegIngredients3,
            16.99,
            20,
            2
        );
        mealKits.add(vegKit3);

        Recipe familyRecipe1 = new Recipe(
            "Classic Spaghetti Bolognese",
            """
            1. Heat olive oil in a large pot over medium heat.
            2. Add ground beef and cook until browned, breaking up with a spoon.
            3. Add diced onions, carrots, and celery; sauté for 5-7 minutes.
            4. Stir in minced garlic and cook for 1 minute until fragrant.
            5. Pour in crushed tomatoes, tomato paste, and Italian herbs.
            6. Reduce heat and simmer for 45 minutes, stirring occasionally.
            7. Meanwhile, cook spaghetti according to package directions.
            8. Drain pasta and toss with a splash of olive oil.
            9. Serve sauce over spaghetti with freshly grated Parmesan.
            """,
            20,
            55,
            "Medium"
        );

        List<Ingredient> familyIngredients1 = new ArrayList<>();
        familyIngredients1.add(new Ingredient("Ground Beef", "500g", Set.of()));
        familyIngredients1.add(new Ingredient("Spaghetti", "400g", Set.of("gluten")));
        familyIngredients1.add(new Ingredient("Crushed Tomatoes", "800g", Set.of()));
        familyIngredients1.add(new Ingredient("Onion", "1 large", Set.of()));
        familyIngredients1.add(new Ingredient("Carrots", "2 medium", Set.of()));
        familyIngredients1.add(new Ingredient("Celery", "2 stalks", Set.of()));
        familyIngredients1.add(new Ingredient("Parmesan Cheese", "100g", Set.of("dairy")));
        familyIngredients1.add(new Ingredient("Italian Herbs", "2 tbsp", Set.of()));

        FamilyKit familyKit1 = new FamilyKit(
            "Spaghetti Bolognese Family Pack",
            "Classic Italian comfort food with rich meat sauce — enough to feed the whole family",
            familyRecipe1,
            familyIngredients1,
            24.99,
            10,
            4
        );
        mealKits.add(familyKit1);

        Recipe familyRecipe2 = new Recipe(
            "Taco Tuesday Fiesta",
            """
            1. Season ground beef with taco seasoning mix.
            2. Cook beef in a skillet over medium-high heat until browned.
            3. Warm tortillas in a dry pan or microwave.
            4. Prepare toppings: shred lettuce, dice tomatoes, slice jalapeños.
            5. Grate cheddar cheese and prepare sour cream and salsa.
            6. Set up a taco bar with all components.
            7. Let everyone build their own tacos with favorite toppings.
            8. Serve with lime wedges and extra hot sauce on the side.
            """,
            15,
            20,
            "Easy"
        );

        List<Ingredient> familyIngredients2 = new ArrayList<>();
        familyIngredients2.add(new Ingredient("Ground Beef", "450g", Set.of()));
        familyIngredients2.add(new Ingredient("Taco Seasoning", "35g packet", Set.of()));
        familyIngredients2.add(new Ingredient("Flour Tortillas", "12 pack", Set.of("gluten")));
        familyIngredients2.add(new Ingredient("Cheddar Cheese", "200g", Set.of("dairy")));
        familyIngredients2.add(new Ingredient("Iceberg Lettuce", "1 head", Set.of()));
        familyIngredients2.add(new Ingredient("Tomatoes", "3 medium", Set.of()));
        familyIngredients2.add(new Ingredient("Sour Cream", "200ml", Set.of("dairy")));
        familyIngredients2.add(new Ingredient("Salsa", "250ml", Set.of()));

        FamilyKit familyKit2 = new FamilyKit(
            "Taco Tuesday Kit",
            "Build-your-own taco night with all the fixings — fun for the whole family",
            familyRecipe2,
            familyIngredients2,
            22.99,
            8,
            4
        );
        mealKits.add(familyKit2);

        Recipe premiumRecipe1 = new Recipe(
            "Pan-Seared Wagyu Steak",
            """
            1. Remove steak from refrigerator 30 minutes before cooking.
            2. Pat dry with paper towels — this ensures a good sear.
            3. Season generously with flaky sea salt and fresh cracked pepper.
            4. Heat cast iron skillet over high heat until smoking hot.
            5. Add a thin layer of high smoke-point oil (avocado or grapeseed).
            6. Carefully place steak in pan — don't move it for 2-3 minutes.
            7. Flip and sear another 2-3 minutes for medium-rare.
            8. Add truffle butter to pan, baste steak while cooking.
            9. Remove and rest on cutting board for 5 minutes.
            10. Slice against the grain and serve with roasted asparagus.
            """,
            35,
            10,
            "Hard"
        );

        List<Ingredient> premiumIngredients1 = new ArrayList<>();
        premiumIngredients1.add(new Ingredient("Wagyu Beef Ribeye", "350g", Set.of()));
        premiumIngredients1.add(new Ingredient("Truffle Butter", "30g", Set.of("dairy")));
        premiumIngredients1.add(new Ingredient("Asparagus", "200g", Set.of()));
        premiumIngredients1.add(new Ingredient("Flaky Sea Salt", "1 tsp", Set.of()));
        premiumIngredients1.add(new Ingredient("Black Pepper", "1 tsp", Set.of()));
        premiumIngredients1.add(new Ingredient("Avocado Oil", "2 tbsp", Set.of()));

        PremiumKit premiumKit1 = new PremiumKit(
            "Wagyu Steak Experience",
            "Premium A5 Wagyu beef with truffle butter — an unforgettable dining experience",
            premiumRecipe1,
            premiumIngredients1,
            49.99,
            5,
            2
        );
        mealKits.add(premiumKit1);

        Recipe premiumRecipe2 = new Recipe(
            "Classic Lobster Thermidor",
            """
            1. Bring large pot of salted water to a rolling boil.
            2. Cook lobster tails for 8-10 minutes until shells turn bright red.
            3. Remove meat from shells, keeping shells intact for serving.
            4. Dice lobster meat into bite-sized pieces.
            5. Make béchamel: melt butter, whisk in flour, add cream gradually.
            6. Stir in Gruyère cheese, Dijon mustard, and a splash of brandy.
            7. Fold lobster meat into the cheese sauce.
            8. Spoon mixture back into lobster shells.
            9. Top with more Gruyère and breadcrumbs.
            10. Broil 3-4 minutes until golden brown and bubbling.
            """,
            30,
            25,
            "Hard"
        );

        List<Ingredient> premiumIngredients2 = new ArrayList<>();
        premiumIngredients2.add(new Ingredient("Lobster Tails", "2 large", Set.of("shellfish")));
        premiumIngredients2.add(new Ingredient("Heavy Cream", "200ml", Set.of("dairy")));
        premiumIngredients2.add(new Ingredient("Gruyère Cheese", "150g", Set.of("dairy")));
        premiumIngredients2.add(new Ingredient("Dijon Mustard", "2 tbsp", Set.of()));
        premiumIngredients2.add(new Ingredient("Brandy", "30ml", Set.of()));
        premiumIngredients2.add(new Ingredient("Butter", "50g", Set.of("dairy")));
        premiumIngredients2.add(new Ingredient("Panko Breadcrumbs", "50g", Set.of("gluten")));

        PremiumKit premiumKit2 = new PremiumKit(
            "Lobster Thermidor",
            "Decadent French classic with succulent lobster in creamy Gruyère sauce",
            premiumRecipe2,
            premiumIngredients2,
            54.99,
            4,
            2
        );
        mealKits.add(premiumKit2);

        return mealKits;
    }

    public static List<Customer> getSampleCustomers() {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("Alice Johnson", "alice.johnson@email.com");
        customers.add(customer1);

        Customer customer2 = new Customer("Bob Smith", "bob.smith@email.com");
        customers.add(customer2);

        Customer customer3 = new Customer("Charlie Brown", "charlie.brown@email.com");
        customers.add(customer3);

        return customers;
    }

    public static List<Order> getSampleOrders(CatalogService catalogService,
                                               CustomerService customerService) {
        List<Order> orders = new ArrayList<>();

        List<Customer> customers = customerService.getAllCustomers();

        if (customers.size() < 2) {
            return orders;
        }

        Customer alice = customers.get(0);
        Customer bob = customers.get(1);

        List<MealKit> mealKits = catalogService.getAllMealKits();

        if (mealKits.size() < 4) {
            return orders;
        }

        MealKit veggieBowl = mealKits.get(0);
        MealKit thaiCurry = mealKits.get(1);
        MealKit spaghetti = mealKits.get(2);
        MealKit tacos = mealKits.get(3);

        LocalDate aliceDeliveryDate = LocalDate.now().plusDays(5);
        Order aliceOrder = new Order(alice, aliceDeliveryDate);

        aliceOrder.addItem(veggieBowl, 2);
        aliceOrder.addItem(thaiCurry, 1);

        orders.add(aliceOrder);

        LocalDate bobDeliveryDate = LocalDate.now().plusDays(7);
        Order bobOrder = new Order(bob, bobDeliveryDate);

        bobOrder.addItem(spaghetti, 1);
        bobOrder.addItem(tacos, 1);

        orders.add(bobOrder);

        return orders;
    }
}
