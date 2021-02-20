package com.avk.calculator;

import java.util.ArrayList;

public class StringCalculator {

    boolean isNegativeFound = false;
    String errorString = "negatives not allowed - ";
    public int add(String s) {

        if(s.isEmpty()) {
            return 0;
        }
        else
        {
            ArrayList<String> delimiter = finddelimiter(s);
            s = processString(s);
            int sum = 0;

            sum = splitAndadd(delimiter,s);


            if(isNegativeFound)
            {

                throw new UnsupportedOperationException(errorString.substring(0,errorString.length()-2));
            }

                return sum;

        }

    }

    private int splitAndadd(ArrayList<String> delimiter,String s) // splitting the numbers from the string
    {

        String tempstr = "";
        int skip = 1,sum = 0;boolean notFound = true;
        for (int i = 0; i < s.length(); i+=skip) {
            notFound = true;
            for(String k: delimiter)
            {
                if(i+k.length() <= s.length() && k.compareTo(s.substring(i,i+k.length()))==0)
                {
                    skip = k.length();
                    notFound = false;
                    break;

                }

            }

            if (notFound) {
                  skip = 1;
                  tempstr += s.charAt(i);

            }
            else {

                sum += ProcessnumberString(tempstr);
                tempstr = "";
                }
        }
        sum += ProcessnumberString(tempstr);

        return sum;
    }
    private int ProcessnumberString (String s)
    {
        int sum = 0;
        String[] innerSplit = s.split("\n");
        if(innerSplit.length>1)
        {
            sum += toNumber(innerSplit[0])+toNumber(innerSplit[1]);
        }
        else
            sum += toNumber(s);

        return sum;
    }
    private ArrayList<String> finddelimiter(String s)           //  finding all the delimiters in the String
    {
        ArrayList <String> delimiter = new ArrayList<>();

        if(isDelimiterGiven(s))
        {

            s = s.split("\n")[0];
            s = s.substring(2);
            if(s.length()>1)
            {
                String tempStr = "";
                for (int i = 0; i < s.length(); i++) {

                    if(s.charAt(i)=='[')
                    {
                        continue;
                    }
                    if(s.charAt(i)==']') {
                        delimiter.add(tempStr);
                        tempStr = "";
                    }
                    else
                    tempStr += s.charAt(i);
                }
            }
            else
            {
                delimiter.add(s);
            }


        }
        else
        {
            delimiter.add(",");

        }

        return delimiter;
    }
    private String processString(String s)
    {
        if(isDelimiterGiven(s)) {

            int index;
            for (index = 2; index < s.length(); index++) {

             if(s.charAt(index)=='\n')
             {
                 break;
             }
            }

            return s.substring(index+1);
        }
        return s;
    }
    private boolean isDelimiterGiven(String s)
    {
        if(s.substring(0,2).compareTo("//")==0)
        {
            return  true;
        }
        return false;

    }
    private int toNumber(String s)              // convert a string into number
    {

           int i = Integer.parseInt(s);
           if(i<0)
           {    isNegativeFound = true;
                errorString += s +", ";
           }
          else if(i>1000)
               i = 0;

           return i;

    }

}
