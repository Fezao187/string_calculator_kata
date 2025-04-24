package org.example.stringCalc;

public class NegativesNotAllowedException extends RuntimeException {
    public NegativesNotAllowedException(String message, String negativeNumbers) {
        super();
        System.out.println("Error: "+ message);
        System.out.println("Negatives found: "+negativeNumbers);
    }
}
