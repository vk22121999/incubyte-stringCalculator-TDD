package com.avk.calculator;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    public void ShouldBe_the_only_number_in_StringWithonly_one_number()
    {
        int expected = 127;

        int result = calculator.add("127");

        assertEquals(expected,result);
    }

    @Test
    public void ShouldReturn_the_sum_of_two_number_in_a_String()
    {
        int expected = 100;
        int result = calculator.add("35,65");

        assertEquals(expected,result);
    }

    @Test
    public void SholudReturn_the_sum_of_all_the_numbers_in_a_String()
    {
        int expected = 1500;

        int result = calculator.add("500,100,100,100,100,600");

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Number in newline is also considered in this test case")
    public void ShouldReturn_the_sum_of_numbers_in_newLine_String()
    {
        int expected = 6;

        int result = calculator.add("1\n2,3");

        assertEquals(expected,result);
    }


}
