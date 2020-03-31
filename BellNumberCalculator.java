package utilities.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;



public class BellNumberCalculator {

    static double  [] arrayA = new double[1000000];
    static double [] arrayB = new double[1000000];

    static double factorial(int num) {
        if(arrayA[num] != Double.MAX_VALUE) return arrayA[num];
        
        return arrayA[num] = num * factorial(num - 1);
    }

    static double combination(int num, int r) {
        return factorial(num) / (factorial(r) * factorial(num - r));
    }

    static double bell(int num) {
        if(arrayB[num] != Double.MAX_VALUE) return arrayB[num];
        double result = 0;
        
        for(int i = 0; i <= num - 1; i++) {
            result += combination(num - 1, i) * bell(i);
        }
        return arrayB[num] = result;
    }

    public static void main(String[] args)
    		throws NumberFormatException, IOException, NegativeNumberException {
        for(int i = 0; i < 1000000; i++) {
            arrayA[i] = Double.MAX_VALUE;
            arrayB[i] = Double.MAX_VALUE;
        }
        arrayA[0] = 1;
        arrayB[0] = 1;
        arrayB[1] = 1;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the size of the partition?");
        while (true) {
            int n = Integer.parseInt(br.readLine());
            
            if(n < 0)
            	throw new NegativeNumberException();
            if(n >= 172)
            	System.out.println(n + " is too large for this calculator to succesfully compute.");
            	
            System.out.println("The bell number of " + n + " is "
            		+ (DecimalFormat.getNumberInstance().format(bell(n)) + ""));
        }
    }

}