package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a random string");
        var scanner = new Scanner(System.in);
        var input = scanner.next();
        if (IsUnique.isUniqueChars(input)) {
            System.out.println("Unique");
        } else {
            System.out.println("Not unique");
        }
    }
}
