package com.ibm.fizzbuzz.api.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Test suite for {@link FizzBuzzService}
 *
 * @author nemeta
 */
class FizzBuzzServiceTest {

    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

    @Test
    void testGenerateFizzBuzzSequence() {
        final int n = 20;
        final List<String> result = fizzBuzzService.generateFizzBuzzSequence(n);
        assertArrayEquals(
                new String[] { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
                        "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz" }, result.toArray());
        assertTrue(result.get(2).equals("Fizz"));
        assertTrue(result.get(4).equals("Buzz"));
        assertTrue(result.get(14).equals("FizzBuzz"));
        assertEquals(n, result.size());
    }

    @Test
    void testGenerateFizzBuzzSequenceInvalidInput() {
        final int n = 0;
        final List<String> result = fizzBuzzService.generateFizzBuzzSequence(n);
        assertTrue(result.isEmpty());
    }
}
