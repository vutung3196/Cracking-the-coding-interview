import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pal", "pali"));
        System.out.println(oneEditAway("pale", "bake"));
        System.out.println('c' - 'a');
    }

    // Solution by me
    public static boolean isOneOrZeroEditing(String input1, String input2) {
        // insert a character and remove
        var temp = "";
        if (input1.length() > input2.length()) {
            temp = input1;
            input1 = input2;
            input2 = temp;
        }
        var insertingOrRemovingCount = 0;
        var replacingCount = 0;
        char[] textInput1 = input1.toCharArray();
        char[] textInput2 = input2.toCharArray();
        var textLengthToCompare = textInput1.length > textInput2.length ? textInput2.length : textInput1.length;
        var differenceBetweenLengths = textInput1.length - textInput2.length;
        if (Math.abs(differenceBetweenLengths) > 1) {
            return false;
        }

        // replace a character
        if (differenceBetweenLengths == 0) {
            for (int i = 0; i < textLengthToCompare; i++) {
                if (textInput1[i] == textInput2[i]) {
                    continue;
                } else {
                    if (replacingCount == 1) {
                        return false;
                    } else {
                        replacingCount += 1;
                    }
                }
            }

        }

        // edit or remove a character
        // pale and ple
        else {
            for (int i = 0; i < textLengthToCompare; i++) {
                if (textInput1[i] == textInput2[i]) {
                    continue;
                } else {
                    if (insertingOrRemovingCount == 1) {
                        if (textInput1[i] == textInput2[i + 1]) {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        insertingOrRemovingCount += 1;
                    }
                }
            }
        }
        return (replacingCount + insertingOrRemovingCount) <= 1;
    }

    // Author's solution
    static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (second.length() + 1 == first.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    private static boolean oneEditInsert(String first, String second) {
        // using two pointers
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while(index2 < second.length() && index1 < first.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                // found difference
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                index2++;
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
}
