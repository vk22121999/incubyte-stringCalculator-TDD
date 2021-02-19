package com.avk.calculator;

public class StringCalculator {


    public int add(String s) {

        if(s.isEmpty()) {
            return 0;
        }
        else
        {
            String delimiter = finddelimiter(s);
            int sum = 0;

            String[] splits = s.split(",");


                for (String i:
                        splits
                     ) {
                    String[] innerSplit = i.split("\n");
                    if(innerSplit.length>1)
                    {
                        sum += toNumber(innerSplit[0])+toNumber(innerSplit[1]);
                    }
                    else
                    sum += toNumber(i);
                }
                return sum;


        }


    }

    public String finddelimiter(String s)
    {
        String delimiter = "";
        if(s.charAt(0)=='/'&&s.charAt(1)=='/')
        {

            delimiter = s.split("\n")[0];
            delimiter = delimiter.substring(2);

        }
        return delimiter;
    }
    public int toNumber(String s)
    {
        return Integer.parseInt(s);
    }


}
