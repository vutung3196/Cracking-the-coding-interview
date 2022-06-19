package Chapter2.LinkedLists.Solution;

public class Solution {
    public static void main(String[] args) {
        var arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;
        arr[3] = 10;
        System.out.println(1234 % 4);
        System.out.println(countDigits(1234));
    }

    public static int countDigits(int num) {
        int count = 0;
        int newNum = num;
        while (newNum != 0) {
            newNum = newNum / 10;
            count++;
        }
        return (num % count);
    }

    public static int[] sortArray(int arr[]) {
        int len = arr.length;
        int small, pos, i, j, temp;
        for (i = 0; i <= len - 1; i++) {
            for (j = i; j < len; j++) {
                temp = 0;
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int countOccurrence(int arr[], int value) {
        int i = 0, count = 0, len = arr.length;
        while (i < len) {
            if (arr[i] == value) {
                count += 1;
            }
            i++;
        }
        return count;
    }
}
