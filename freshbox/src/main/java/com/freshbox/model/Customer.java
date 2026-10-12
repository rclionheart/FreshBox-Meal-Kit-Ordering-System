package com.freshbox.model;

public class Customer implements Displayable {

    private int id;
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // LEARNER_TODO: Implement this overloaded constructor.
    // Set the name field from the parameter, and set email to an empty string "".
    // This constructor allows creating a Customer without an email address.
    public Customer(String name) {
        this.name = name;
        this.email = "";
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
        if (email == null || email.isEmpty()) {
            this.email = email;
            return;
        }
        if (email.indexOf("@") == -1 || email.indexOf("@") != email.lastIndexOf("@")) {
            throw new IllegalArgumentException("Email must contain exactly one '@' symbol.");
        }
        int atIndex = email.indexOf("@");
        if (atIndex == 0) {
            throw new IllegalArgumentException("Email must have content before the '@' symbol.");
        }
        if (atIndex == email.length() - 1) {
            throw new IllegalArgumentException("Email must have content after the '@' symbol.");
        }
        String domainPart = email.substring(atIndex + 1);
        if (!domainPart.contains(".")) {
            throw new IllegalArgumentException("Email domain must contain a '.' symbol.");
        }
        this.email = email;
    }

    @Override
    public String toDisplayString() {
        if (email == null || email.isEmpty()) {
            return name + " (no email)";
        }
        return name + " (" + email + ")";
    }
}
