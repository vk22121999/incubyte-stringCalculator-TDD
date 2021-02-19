package com.avk.calculator;

public class StringCalculator {


    public int add(String s) {

        if(s.isEmpty()) {
            return 0;
        }
        else
        {

            String[] splits = s.split(",");
            if(splits.length>1)
                return toNumber(splits[0])+toNumber(splits[1]);
            else
                return toNumber(s);
        }


    }

    public int toNumber(String s)
    {
        return Integer.parseInt(s);
    }


}
