package org.example.stringCalc;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        } else {
            String[] arrNum = numbers.split(",");
            return sumOfArr(arrNum);
        }
    }

    private int sumOfArr(String[] arr){
        int sum=0;
        for(String s: arr){
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}