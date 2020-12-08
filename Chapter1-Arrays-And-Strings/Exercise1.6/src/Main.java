import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) {
        var input = "aabbbcc";
        String output = compressString(input);
        System.out.println(output);
    }

    // Author's solution
    static String compressString(String input) {
        // aabccc => a2b1c3
        StringBuilder compress = new StringBuilder();
        int countConsecutive = 0;
        for(int i = 0; i < input.length(); i++) {
            countConsecutive += 1;
            if(i + 1 >= input.length() || input.charAt(i) != input.charAt(i+1)) {
                compress.append(input.charAt(i));
                compress.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        String compressedInput = compress.toString();
        return compressedInput.length() > input.length() ? input : compressedInput;
    }

    // my solution
    static String compressStringUsingHashMap(String input) {
        // aabccc => a2b1c3
        StringBuilder processedText = new StringBuilder();
        HashMap<Character, Integer> textTable = new HashMap<>();
        for(int i = 0; i < input.length(); i++) {
            if(textTable.containsKey(input.charAt(i))) {
                textTable.put(input.charAt(i), textTable.get(input.charAt(i)) + 1);
            } else {
                if(textTable.size() == 0) {
                    textTable.put(input.charAt(i), 1);
                } else {
                    String count = textTable.get(input.charAt(i - 1)).toString();
                    processedText.append(input.charAt(i-1));
                    processedText.append(count);
                    textTable.remove(input.charAt(i-1));
                    textTable.put(input.charAt(i), 1);
                }
            }
        }

        processedText.append(input.charAt(input.length() - 1));
        var finalCount = textTable.get(input.charAt(input.length() - 1));
        processedText.append(finalCount);
        String processedInput = processedText.toString();
        return processedInput.length() > input.length() ? input : processedInput;
    }
}

