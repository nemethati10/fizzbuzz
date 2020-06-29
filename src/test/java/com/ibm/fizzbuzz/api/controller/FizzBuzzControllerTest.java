package com.ibm.fizzbuzz.api.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.fizzbuzz.FizzBuzzApplication;
import com.ibm.fizzbuzz.entity.FizzBuzzBE;

/**
 * Test suite for {@link FizzBuzzController}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FizzBuzzApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzControllerTest {

    private static final String URL = "/api/v1/fizzbuzz/";

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    public FizzBuzzControllerTest() {

    }

    @Test
    public void testGetFizzBuzzSequence() {
        final int pathVariable = 10;
        final ResponseEntity<FizzBuzzBE> fizzBuzz =
                restTemplate.getForEntity(getRootUrl() + URL + pathVariable, FizzBuzzBE.class);
        assertNotNull(fizzBuzz);
        assertEquals(pathVariable,fizzBuzz.getBody().getSequence().size());
        assertTrue(fizzBuzz.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void testGetFizzBuzzSequenceInvalidNumber() {
        final int pathVariable = 0;
        final ResponseEntity<FizzBuzzBE> fizzBuzz =
                restTemplate.getForEntity(getRootUrl() + URL + pathVariable, FizzBuzzBE.class);
        assertNotNull(fizzBuzz);
    }

    @Test
    public void testGetFizzBuzzSequenceInvalidRequestMethod() {
        final int pathVariable = 0;
        final ResponseEntity<FizzBuzzBE> fizzBuzz =
                restTemplate.postForEntity(getRootUrl() + URL + pathVariable, new FizzBuzzBE(), FizzBuzzBE.class);
        assertNotNull(fizzBuzz);
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), fizzBuzz.getStatusCodeValue());
    }

    @Test
    public void testGetFizzBuzzSequenceInvalidPathVariable() {
        final String invalidPathVariable = "apple";
        final ResponseEntity<FizzBuzzBE> fizzBuzz =
                restTemplate.getForEntity(getRootUrl() + URL + invalidPathVariable, FizzBuzzBE.class);
        assertNotNull(fizzBuzz);
        assertTrue(fizzBuzz.getStatusCode().is4xxClientError());
        assertEquals(HttpStatus.BAD_REQUEST.value(), fizzBuzz.getStatusCodeValue());
    }

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

}
