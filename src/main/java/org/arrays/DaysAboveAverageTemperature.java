package org.arrays;

import java.util.Scanner;

public class DaysAboveAverageTemperature {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("How many day(s) temperature?");
        int numDays = console.nextInt();
        int[] days = new int[numDays];
        int sum = 0;
        for(int i = 0; i < numDays; i++) {
            System.out.println("Day " + i + "'s high temp: ");
            int next = console.nextInt();
            days[i] = next;
            sum += next;
        }
        double average = sum/numDays;
        System.out.println("Average temperature = " + average);
        int daysAboveAverage = 0;
        for(int i = 0; i < numDays; i++) {
            if(days[i] > average) {
                daysAboveAverage++;
            }
        }
        System.out.println("Days Above average temperature = " + daysAboveAverage);
    }
}
