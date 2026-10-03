package com.freshbox.model;

public class Customer implements Displayable {

    private int id;
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        setEmail(email);
    }

    // LEARNER_TODO: Implement this overloaded constructor.
    // Set the name field from the parameter, and set email to an empty string "".
    // This constructor allows creating a Customer without an email address.
    public Customer(String name) {
        // set fields here
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // LEARNER_TODO: Implement email validation in setEmail(String email).
    // The method should:
    //   1. If email is null or empty, store it and return (no validation needed)
    //   2. Check that email contains exactly one '@' symbol
    //   3. Check that there is content before the '@'
    //   4. Check that there is content after the '@'
    //   5. Check that the domain part contains a '.'
    //   6. If any check fails, throw IllegalArgumentException with a descriptive message
    //   7. If all checks pass, store the email
    //
    // Hint: The String class has methods for finding character positions and extracting substrings.
    public void setEmail(String email) {
        this.email = (email == null) ? "" : email;
    }

    @Override
    public String toDisplayString() {
        if (email == null || email.isEmpty()) {
            return name + " (no email)";
        }
        return name + " (" + email + ")";
    }
}
