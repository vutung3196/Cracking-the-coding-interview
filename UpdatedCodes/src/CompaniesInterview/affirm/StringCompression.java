package CompaniesInterview.affirm;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
//        System.out.println(compress(chars));
        int a = 1;
        char character = (char) (a + '0'); // Printing the character System.out.println('The character representation of ' + num + ' is: ' +
        compress(chars);
    }

    public static int compressWorkingSolution(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j;

        while (i < chars.length) {
            int count = 1;

            j = i + 1;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
                count++;
                if (j == chars.length) break;
            }

            if (count == 1) {
                sb.append(chars[i]);
            } else if (count > 1) {
                sb.append(chars[i]);
                sb.append(count);
            }

            // for next iteration
            i = j;
        }

        var str = sb.toString();
        for (int k = 0; k < str.length(); k++) {
            chars[k] = str.charAt(k);
        }

        return str.length();
    }

    public static int compressWorkingSolutionOther(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int i = 0;
        int j;
        int current = 0;
        while (i < chars.length) {
            int count = 1;

            j = i + 1;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
                count++;
                if (j == chars.length) break;
            }

            chars[current] = chars[i];
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[current + 1] = digit;
                }
            }

            // for next iteration
            i = j;
            current = j;
        }



        return current;
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int i = 0;
        int j;
        int current = 0;
        while (i < chars.length) {
            int count = 1;

            j = i + 1;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
                count++;
            }

            chars[current] = chars[i];
            current = current + 1;
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[current] = digit;
                    current++;
                }
            }

            i += count;
        }



        return current;
    }
}
