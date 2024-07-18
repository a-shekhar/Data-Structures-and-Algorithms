package org.recursion;

/* Given two integers x and n, write a function to compute xn. */
public class PowerOfNumber {
    public static double power(double base, int exponent){
        if(exponent < 0){
            base = 1/base;
            exponent = -exponent;
        }
            // TODO
        if(exponent == 0){
            return 1;
        }

         return base * power(base, exponent-1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
        System.out.println(power(2.1, 3));
        System.out.println(power(2, -2));

    }
}
