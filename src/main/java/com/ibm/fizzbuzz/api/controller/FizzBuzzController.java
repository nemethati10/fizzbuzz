package com.ibm.fizzbuzz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fizzbuzz.api.service.FizzBuzzService;
import com.ibm.fizzbuzz.entity.FizzBuzzBE;

/**
 * Controller class for the FizzBuzz resource.
 */
@RestController
@RequestMapping("/api/v1")
public class FizzBuzzController {

    private FizzBuzzService fizzBuzzService;
    private static final String ERROR_MESSAGE =
            "Invalid request, n must be a positive number and must be bigger than 0!";

    @Autowired
    FizzBuzzController(final FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    /**
     * Returns the FizzBuzz sequence.
     *
     * @param n
     *         the last element of the sequence
     *
     * @return FizzBuzz sequence
     */
    @GetMapping(value = "/fizzbuzz/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FizzBuzzBE> getFizzBuzzSequence(@PathVariable(value = "n") final int n) {
        final FizzBuzzBE fizzBuzz = new FizzBuzzBE();

        if (n < 1) {
            fizzBuzz.setMessage(ERROR_MESSAGE);
            return new ResponseEntity<>(fizzBuzz, HttpStatus.BAD_REQUEST);
        }

        final List<String> sequence = fizzBuzzService.generateFizzBuzzSequence(n);
        fizzBuzz.setSequence(sequence);

        return new ResponseEntity<>(fizzBuzz, HttpStatus.OK);
    }

}
