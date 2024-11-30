package companies.trendmicro.codilitytest;

import java.util.ArrayList;
import java.util.List;

public class NextNumber {
    public static void main(String[] args) {
        System.out.println(nextNumber(6)); // 8
        System.out.println(nextNumber(8)); // 80
        System.out.println(nextNumber(33)); // 90
        System.out.println(nextNumber(69)); // 90
        System.out.println(nextNumber(300)); // 80
    }


//    public static int nextNumber(int roseNumber) {
//        // if rose number contains 7 or multiple of any number contains 7 -> return -1;
//        if (!isValid(roseNumber)) {
//            return -1;
//        }
//
//        return findNextValidNumber(roseNumber);
//    }
//
//    public static boolean isValid(int number) {
//        if (hasSeven(number)) {
//            return false;
//        }
//
//        if (number % 7 == 0) {
//            return false;
//        }
//
//        if (isMultipleOfNumberWith7(number)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    private static boolean isMultipleOfNumberWith7(int number) {
//        List<Integer> factors = getFactors(number);
//        for (var factor : factors) {
//            if (String.valueOf(factor).contains("7")) return true;
//        }
//
//        return false;
//
//    }
//
//    private static List<Integer> getFactors(int number) {
//        List<Integer> factors = new ArrayList<>();
//        for (int i = 1; i * i <= number; i++) {
//            if (number % i == 0) {
//                factors.add(i);
//                if (number / i != i) {
//                    factors.add(number / i);
//                }
//            }
//        }
//        return factors;
//    }
//
//    public static boolean hasSeven(int number) {
//        return String.valueOf(number).contains("7");
//    }
//
//    public static int findNextValidNumber(int number) {
//        var nextNumber = number + 1;
//        while (!isValid(nextNumber)) {
//            nextNumber++;
//        }
//
//        return nextNumber;
//    }

    public static int nextNumber(int number) {
        if (!isValid(number)) {
            return -1;
        }

        return findNextNumber(number);
    }

    public static boolean hasSeven(int number) {
        return String.valueOf(number).contains("7");
    }

    public static int findNextNumber(int number) {
        number++;
        while (!isValid(number)) {
            number++;
        }

        return number;

    }

    public static boolean isValid(int number) {
        if (hasSeven(number)) {
            return false;
        }

        if (number % 7 == 0) {
            return false;
        }

        if (isMultiplierOfNumber7(number)) {
            return false;
        }
        return true;
    }

    public static List<Integer> getFactors(int number) {
        var result = new ArrayList<Integer>();
        for (int i = 1; i * i < number; i++) {
            if (number % i == 0) {
                result.add(i);
                if (number / i != i) {
                    result.add(number / i);
                }
            }
        }
        return result;
    }

    public static boolean isMultiplierOfNumber7(int number) {
        var factors = getFactors(number);

        for (var factor : factors) {
            if (hasSeven(factor)) return true;
        }

        return false;
    }


}
