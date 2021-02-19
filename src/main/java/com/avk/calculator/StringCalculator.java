package com.avk.calculator;

public class StringCalculator {


    public int add(String s) {

        if(s.isEmpty())
        {
            return 0;
        }
        if(s.length()==1)
        {
            Integer i = Integer.parseInt(s);
            return i;
        }
        else
        {
            String[] splits = s.split(",");
            return Integer.parseInt(splits[0])+Integer.parseInt(splits[1]);
        }


    }


}
