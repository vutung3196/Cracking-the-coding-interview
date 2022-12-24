package CompaniesInterview.snowflake.happynumber;

import java.util.*;

public class Solution {
    public boolean isHappy(int n) {
        var currentNumber = n;
        // repeat the process until the number equals to 1
        Set<Integer> currentSetOfNumbers = new HashSet<Integer>();
        while (currentNumber != 1 && !currentSetOfNumbers.contains(currentNumber)) {
            currentSetOfNumbers.add(currentNumber);
            currentNumber = sumSquareOfAllDigits(currentNumber);
        }
        return currentNumber == 1;
    }

    public int sumSquareOfAllDigits(int number) {
        List<Integer> numbers = new ArrayList<Integer>();
        int sumSquare = 0;
        while (number > 0) {
            var currentDigit = (number % 10);
            sumSquare += currentDigit *  currentDigit;
            number = number / 10;
        }

        return sumSquare;
    }
}
