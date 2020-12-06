import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        char[] a = { 'M', 'r', 'L', 'L', 'O', ' ', ' ', 'T', ' ', ' '};
        var result = URLify.convert(a, 8);
        System.out.println(result);
    }


}
