package com.ibm.fizzbuzz.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Entity class representing the FizzBuzz Response.
 *
 * @author nemeta
 */
public class FizzBuzzBE {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> sequence;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public List<String> getSequence() {
        return sequence;
    }

    public void setSequence(final List<String> sequence) {
        this.sequence = sequence;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
