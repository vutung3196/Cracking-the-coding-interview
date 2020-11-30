package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsUniqueTest {
    @Test
    void isUniqueChars_ShouldBeUniqueChars() {
        boolean result = IsUnique.isUniqueChars("abc");
        assertEquals(true, result);
    }

    @Test
    void isUniqueChars_ShouldNotBeUniqueChars() {
        boolean result = IsUnique.isUniqueChars("aabc");
        assertEquals(false, result);
    }
}
