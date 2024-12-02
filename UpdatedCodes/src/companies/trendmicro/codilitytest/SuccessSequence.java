package companies.trendmicro.codilitytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuccessSequence {
    public static void main(String[] args) {
        System.out.println("Please enter a number to find the sequence: ");
        int n = new Scanner(System.in).nextInt();
        String[] result = findSequence(n);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String[] findSequence(int n) {
        List<String> resultArray = new ArrayList<>();
        int p = 1;
        while (p * p <= n) {
            double currentSum = 0;
            int m = 0;
            while (currentSum < n) {
                currentSum += Math.pow((p + m), 2);
                if (currentSum == n) {
                    var sb = new StringBuilder();
                    sb.append(m + 1 + " ");
                    for (int i = 0; i < m + 1; i++) {
                        if (i == m) {
                            sb.append(p + i);
                        } else {
                            sb.append((p + i) + " ");
                        }
                    }

                    resultArray.add(sb.toString());
                }
                m++;
            }
            p++;
        }
        var result = new ArrayList<String>();
        var length = resultArray.size();
        result.add(String.valueOf(length));
        result.addAll(resultArray);
        return result.toArray(new String[0]);
    }
}
