package com.avk.calculator;

public class StringCalculator {


    public int add(String s) {

        if(s.isEmpty()) {
            return 0;
        }
        else
        {
            int sum = 0;

            String[] splits = s.split(",");


                for (String i:
                        splits
                     ) {

                    sum += toNumber(i);
                }
                return sum;


        }


    }

    public int toNumber(String s)
    {
        return Integer.parseInt(s);
    }


}
