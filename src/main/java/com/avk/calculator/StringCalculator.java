package com.avk.calculator;

public class StringCalculator {

    boolean isNegativeFound = false;
    String errorString = "negatives not allowed - ";
    public int add(String s) {

        if(s.isEmpty()) {
            return 0;
        }
        else
        {
            String delimiter = finddelimiter(s);
            s = processString(s);
            int sum = 0;

            String[] splits = s.split(delimiter);

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
            if(isNegativeFound)
            {

                throw new UnsupportedOperationException(errorString.substring(0,errorString.length()-2));
            }

                return sum;

        }

    }

    public String finddelimiter(String s)
    {
        String delimiter = ",";
        if(isDelimiterGiven(s))
        {

            delimiter = s.split("\n")[0];
            delimiter = delimiter.substring(2);

        }
        return delimiter;
    }

    public String processString(String s)
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
    public boolean isDelimiterGiven(String s)
    {
        if(s.substring(0,2).compareTo("//")==0)
        {
            return  true;
        }
        return false;

    }
    public int toNumber(String s)
    {

           int i = Integer.parseInt(s);
           if(i<0)
           {    isNegativeFound = true;
                errorString += s +", ";
           }

           return i;

    }



}
