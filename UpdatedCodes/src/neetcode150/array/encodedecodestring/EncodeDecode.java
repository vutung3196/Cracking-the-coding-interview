package neetcode150.array.encodedecodestring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        var strs = Arrays.asList(
            "lint", "code", "love", "you");
        var result = new EncodeDecode().encode(strs);
        System.out.println(result);
        System.out.println("Decode part: ");
        var decode = new EncodeDecode().decode(result);
        for (var word : decode) {
            System.out.println(word);
        }
    }

    // idea is to add a number along with # icon between different word.
    public String encode(List<String> strs) {
        // encode a list of strings to a string
        if (strs.isEmpty()) return null;
        var sb = new StringBuilder();
        for (var str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null) return new ArrayList<>();
        var result = new ArrayList<String>();
        int i = 0;
        while (i < str.length()) {
            int numberSymbol = str.indexOf("#", i);
            int size = Integer.valueOf(str.substring(i, numberSymbol));
            result.add(str.substring(numberSymbol + 1, numberSymbol + size + 1));
            i = numberSymbol + size + 1;
        }

        return result;
    }
}
