package CompaniesInterview.snowflake.duplicateswords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        // ArrayList<String> strings = new ArrayList<String>();
        // strings.add("Hello, World!");
        // strings.add("Welcome to CoderPad.");
        // strings.add("This pad is running Java " + Runtime.version().feature());

        // for (String string : strings) {
        //   System.out.println(string);
        // }

        var output = findDuplicates("The dog is eating a dog");
        for (var element : output) {
            System.out.println(element);
        }
    }


    public static String[] findDuplicates(String input) {
        input = input.toLowerCase();

        if (input == null || input.isEmpty()) {
            return new String[] {};
        }
        Set<String> duplicates = new HashSet<>();

        String[] words = input.split("\\s+");
        Set<String> set = new HashSet<>();

        for (String word : words) {
            if (!set.add(word)) {
                duplicates.add(word);
            }
        }
        return Arrays.copyOf(
                duplicates.toArray(),
                duplicates.size(),
                String[].class
        );
    }
}
