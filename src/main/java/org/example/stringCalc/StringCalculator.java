package org.example.stringCalc;

public class StringCalculator {
    public int add(String numbers){
       if(numbers.isEmpty()){
           return 0;
       } else if (numbers.length()==1) {
           return Integer.parseInt(numbers);
       } else if (numbers.contains(",")) {
           String[] arr = numbers.split(",");

           return Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
       }
        return -1;
    }
}