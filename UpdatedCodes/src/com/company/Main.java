package com.company;

public class Main {
    public static void main(String[] args) {
        // write your code here
        // C, C++
        // 987654321
        int a = 5;
        int b = 7;
        b =  a++;
        a = a + 1;
        System.out.println(a);
        System.out.println(b);
    }

    private static void showOddNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            var a = input.charAt(i);
            var stringNumber = String.valueOf(a);
            var number = Integer.parseInt(stringNumber);
            if (number % 2 != 0) {
                System.out.println(number);
            }
        }
    }
}
