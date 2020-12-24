public class URLify {
    public static String convert(char[] input, int trueLength) {
        // for loop => find space => replace with %20
        StringBuilder convert = new StringBuilder();
        for (int i = 0; i < trueLength; i++) {
            if (input[i] == ' ') {
                convert.append("%20");
            } else if (input[i] != ' ') {
                convert.append(input[i]);
            }
        }

        return convert.toString();
    }

    public static char[] replaceSpace(char[] str, int length) {
        int spaceCount = 0, newLength, i;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = spaceCount * 2 + length;
        str[newLength] = '\0';
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        String a = "";
        return str;
    }
}
