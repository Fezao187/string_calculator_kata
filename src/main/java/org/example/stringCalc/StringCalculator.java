package org.example.stringCalc;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        } else if (numbers=="1") {
            return 1;
        } else{
            return -1;
        }
    }
}