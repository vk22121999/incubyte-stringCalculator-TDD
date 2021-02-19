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
    public void shouldBe_zero_on_EmptyString()
    {
        int expected = 0;

        int result = calculator.add("");

        assertEquals(expected,result);
    }

    @Test
    public void ShouleBe_the_only_number_in_StringWithonly_one_number()
    {
        int expected = 1;

        int result = calculator.add("1");

        assertEquals(expected,result);
    }

    @Test
    public void ShoulsReturn_the_sum_of_two_number_in_a_String()
    {
        int expected = 3;
        int result = calculator.add("1,2");

        assertEquals(expected,result);
    }
}
