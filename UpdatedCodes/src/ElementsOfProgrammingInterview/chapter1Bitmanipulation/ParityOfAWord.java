package ElementsOfProgrammingInterview.chapter1Bitmanipulation;

public class ParityOfAWord {
    public static void main(String[] args) {
        System.out.println(parityOfAWord(1011));
    }

    static int parityOfAWord(long number) {
        short count = 0;
        while (number > 0) {
            count += number & 1;
            number >>>= 1;
        }
        return count % 2 == 0 ? 0 : 1;
    }

}
