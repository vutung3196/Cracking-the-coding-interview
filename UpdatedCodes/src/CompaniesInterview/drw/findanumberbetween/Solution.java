package CompaniesInterview.drw.findanumberbetween;

public class Solution {

    public static void main(String[] args) {
        System.out.println(countNumberOfXUsingForLoop(4, 17));
    }

    // Given A and B, find the number of integer X such that X*(X+1) falls between [A, B], both inclusive.
    //Constraint:
    //1 <= A <= B <= 1e9
    //Example:
    //A = 4, B = 17
    //X = 3
    //3*(3+1) = 12 falls between [4, 17]
    //X = 4
    //4*(4+1) = 20 does not fall between [4, 17]
    //X = 5
    //5*(5+1) = 30 does not fall between [4, 17]
    //X = 6
    //6*(6+1) = 42 does not fall between [4, 17]
    //X = 7
    //7*(7+1) = 56 does not fall between [4, 17]
    //X = 8
    //8*(8+1) = 72 does not fall between [4, 17]
    //X = 9
    //9*(9+1) = 90 does not fall between [4, 17]
    public static int countNumberOfX(int A, int B) {
        int count = 0;
        int x = 1;
        while (x * (x + 1) <= B) {
            if (x * (x + 1) >= A) {
                System.out.println(x);
                count++;
            }
            x++;
        }
        System.out.println("====");
        return count;
    }

    public static int countNumberOfXUsingForLoop(int A, int B) {
        int count = 0;
        int x = 1;
        var number = Math.sqrt(B);
        for (x = 1;  x < number; x++) {
            if (x * (x+1) <= B && x *(x+1) >= A) {
                count++;
            }
        }
        return count;
    }
}
