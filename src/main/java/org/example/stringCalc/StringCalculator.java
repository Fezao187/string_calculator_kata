package org.example.stringCalc;

import java.util.ArrayList;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        } else {
            String[] arrNum;
            if(numbers.contains("//")){
                String removeNewLine = numbers.substring(numbers.indexOf("\n")+1);
                arrNum=removeNewLine.split("["+customDelim(numbers)+"\\n]+");
            } else {
                arrNum = numbers.split("[\\,\\n]+");
            }
            return sumOfArr(arrNum);
        }
    }

    private int sumOfArr(String[] arr){
        checkNegNum(arr);
        int sum=0;
        for(String s: arr){
            if(Integer.parseInt(s)<1000){
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    private String customDelim(String number){
        String delim="";
        if(number.contains("[")){
            delim= number.substring(number.indexOf("["),number.lastIndexOf("]"));
            if(countOcurrences(number,'[')>1){
                String[] customDelims=delim.split("\\]\\[");
                delim = String.join("|\\",customDelims);
            }
        } else {
            delim = number.substring(number.indexOf("/")+2,number.indexOf("\n"));
        }
        return "\\"+delim;
    }

    private void checkNegNum(String[] arr){
        ArrayList<String> arrList = new ArrayList<>();
        for(String s: arr){
            if(s.contains("-")){
                arrList.add(s);
            }
        }
        if(arrList.size()!=0){
            String negNum = String.join(", ",arrList);
            throw new NegativesNotAllowedException("Negatives not allowed",
                    negNum);
        }
    }

    private int countOcurrences(String str, char target){
        int count =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==target){
                count++;
            }
        }
        return count;
    }
}