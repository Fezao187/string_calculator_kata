package org.example.stringCalc;

import org.example.stringCalc.NegativesNotAllowedException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers){
        Matcher matcher = Pattern.compile("-?\\d+")
                .matcher(numbers);
        if(!matcher.find()){
            return 0;
        } else {
            if(numbers.contains("//")){
                String removeNewLine=numbers.substring(numbers.indexOf("\n")+1);
                String[] nums= removeNewLine.split("["+customDelim(numbers)+"]+");
                return addNums(nums);
            }
            String[] nums = numbers.split("[,\\n]");
            return addNums(nums);
        }
    }

    private int addNums(String[] numbers){
        ArrayList<Integer> arrList= new ArrayList<>();
        int sum =0;
        for(String s: numbers){
            int num = Integer.parseInt(s);
            if(num<0){
                arrList.add(num);
            }
            if(num<=1000){
                sum += num;
            }
        }
        if (!arrList.isEmpty()){
            throw new NegativesNotAllowedException("Negatives not Allowed!", arrList);
        }
        return sum;
    }

    public String customDelim(String numbers){
        String delim;
        if(numbers.contains("[")){
            delim = numbers.substring(numbers.indexOf("[")+1, numbers.lastIndexOf("]"));
            if(countOccurrences(numbers,'[')>1){
                String[] customDelims=delim.split("\\]\\[");
                delim=String.join("|\\",customDelims);
            }
        } else {
            delim = numbers.substring(numbers.indexOf("/")+2,numbers.indexOf("\n"));
        }

        return "\\"+delim;
    }

    public int countOccurrences(String str, char target){
        int count =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==target){
                count++;
            }
        }
        return count;
    }
}