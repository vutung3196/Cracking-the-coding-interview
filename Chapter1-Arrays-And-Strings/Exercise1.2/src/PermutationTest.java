import org.testng.Assert;
import org.junit.jupiter.api.Test;


class PermutationTest {
    @Test
    void check() {
        var result = Permutation.check("abcd", "dabc");
        Assert.assertEquals(true, result);
    }

    @Test
    void checkUsingSort() {
        var result = Permutation.checkUsingSort("abcd", "dabc");
        Assert.assertEquals(true, result);
    }

    @Test
    void checkUsingOptimalPermutation() {
        var result = Permutation.permutation("adba", "cabd");
        Assert.assertEquals(false, result);
    }
}