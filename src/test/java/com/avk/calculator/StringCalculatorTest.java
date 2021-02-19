package com.avk.calculator;


import org.junit.*;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator calculator = null;

    @Before
    public void setUp()
    {
        calculator = new StringCalculator(); // setting up a new StringCalculator before each test

    }

    @After
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

    @Test
    public void ShouldReturn_the_sum_of_number_separated_by_given_delimiter()
    {
        int expected = 24;

        int result = calculator.add("//;\n4;4;4;6;6");

        assertEquals(expected,result);

    }

    @Test(expected = Exception.class)
    public void ShouldReturn_Exception_message_negative_numbers_in_string()
    {

            calculator.add("//-\n9-4-4--3");



    }

    @Test
    public void ShouldReturn_Sum_of_number_less_than_1000_only_in_string()
    {
        int expected = 15;

        int result = calculator.add("///\n2/8/1001/5");

        assertEquals(expected,result);
    }

    @Test
    public void ShouldReturn_Sum_of_number_with_delimiter_length_more_than_one()

    {
        int expected = 35;

        int result = calculator.add("//[;;;]\n14;;;12\n9");

        assertEquals(expected,result);
    }

    @Test
    public void ShouldReturn_Sum_of_number_with_multiple_delimiter_length_more_than_one()
    {
        int expected = 75;

        int result = calculator.add("//[;;;][+++]\n25+++15;;;10\n25");

        assertEquals(expected,result);
    }


}
