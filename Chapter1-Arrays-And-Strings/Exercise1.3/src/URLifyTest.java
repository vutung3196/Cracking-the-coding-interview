import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class URLifyTest {

    @Test
    void convert() {

        char[] a = { 'M', 'r', 'L', 'L', 'O', ' ', 'T' };
        var result = URLify.convert(a, 7);
        Assert.assertEquals("HELLO%20T", result);
    }
}