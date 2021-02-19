package com.avk.calculator;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator calculator = null;

    @BeforeEach
    public void setUp()
    {
        calculator = new StringCalculator(); // setting up a new StringCalculator before each test

    }

    @AfterEach
    public void destroy()
    {
        calculator = null; // clearing the calculator after every test
    }
    @Test
    public void shouldReturn_zero_on_EmptyString()
    {
        int expected = 0;

        int result = calculator.add("");

        assertEquals(expected,result);
    }
}
