package com.example.blog.model;

public enum Category {
    DEV("Programowanie"),
    DEV_OPS("Administracja"),
    TESTING("Testowanie");

    private String name;

    Category(String name) {
    }

    public String getName() {
        return name;
    }
}
