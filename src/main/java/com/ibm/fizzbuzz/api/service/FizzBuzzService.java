package com.ibm.fizzbuzz.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Service class generating the FizzBuzz sequence.
 *
 * @author nemeta
 */
@Service
public class FizzBuzzService {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    /**
     * Generates the FizzBuzz sequence up until a given value.
     *
     * @param n
     *         the last element of the sequence
     *
     * @return the sequence as a list
     */
    public List<String> generateFizzBuzzSequence(final int n) {
        final List<String> sequence = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sequence.add(FIZZ_BUZZ);
            } else if (i % 3 == 0) {
                sequence.add(FIZZ);
            } else if (i % 5 == 0) {
                sequence.add(BUZZ);
            } else {
                sequence.add(String.valueOf(i));
            }
        }
        return sequence;
    }

}
