
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessorTest {
    StringProcessor processor=new StringProcessor();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld",
                processor.concatenate("Hello", "World"));
    }

    @Test
    void testConcatenateWithNull() {
        assertEquals("",
                processor.concatenate("", ""));
    }

    @Test
    void testConcatenateWithNullFirstString() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.concatenate(null, "World");
        });
    }

    @Test
    void testConcatenateWithNullSecondString() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.concatenate("Hello", null);
        });
    }



    @Test
    void testPalindromeTrue() {
        assertTrue(processor.isPalindrome("madam"));
    }

    @Test
    void testPalindromeFalse() {
        assertFalse(processor.isPalindrome("hello"));
    }

    @Test
    void testPalindromeSingleCharacter() {
        assertTrue(processor.isPalindrome("a"));
    }

    @Test
    void testPalindromeNull() {
        assertFalse(processor.isPalindrome(null));
    }

    @Test
    void testPalindromeEmptyString() {
        assertTrue(processor.isPalindrome(""));
    }
}
