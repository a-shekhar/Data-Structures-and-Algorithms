package org.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        System.out.println( (int) coordinate1.charAt(0) );
        System.out.println(Character.valueOf( coordinate1.charAt(1)));
        int sum1 = (int) coordinate1.charAt(0) + Character.valueOf(coordinate1.charAt(1));
        int sum2 = (int) coordinate2.charAt(0) + Character.valueOf(coordinate2.charAt(1));
        System.out.println(sum1);
        return sum1%2 == 0 && sum2%2 == 0;
    }


    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        Test t = new Test();
        System.out.println(t.checkTwoChessboards("a1", "c3"));
    }
}
