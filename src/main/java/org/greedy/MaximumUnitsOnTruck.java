package org.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
Return the maximum total number of units that can be put on the truck.


 */
public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1];
            }
        };
        Arrays.sort(boxTypes, comparator);
        int totalWeight = 0;
        int totalValue = 0;
        for(int[] boxType : boxTypes) {
            System.out.println(Arrays.toString(boxType));
            if(totalWeight + boxType[0] <= truckSize){
                totalValue += (boxType[0] * boxType[1]);
                totalWeight += boxType[0];
            }else{
                totalValue += ((truckSize - totalWeight) * boxType[1]);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{
                {1,3}, {2, 2}, {3,1}
        };
        int truckSize = 4;
        MaximumUnitsOnTruck maximumUnitsOnTruck = new MaximumUnitsOnTruck();
        System.out.println(maximumUnitsOnTruck.maximumUnits(boxTypes, truckSize)); // Output: 8
    }
}
