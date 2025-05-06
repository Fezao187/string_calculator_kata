package org.example.stringCalc;

import java.util.ArrayList;

public class NegativesNotAllowedException extends RuntimeException {
    public NegativesNotAllowedException(String message, ArrayList<Integer> number) {
        super();
        System.out.println("error: "+message);
        System.out.println("Negatives found: ");
        System.out.print(number);
    }
}
