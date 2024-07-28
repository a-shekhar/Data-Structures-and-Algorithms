package org.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
    @Override
    public String toString(){
        return "Value: " + value + ", Weight: " + weight;
    }
}

public class FractionalKnapsack {
    static double getRatio(Item item) {
        //System.out.println((double) item.value / item.weight);
        return (double) item.value / item.weight;
    }

    static double fractionalKnapsack(int weight, Item[] arr, int n) {
        // Your code here
        Comparator<Item> comparator = new Comparator<>() {
            @Override
            public int compare(Item o1, Item o2) {
                //System.out.println(getRatio(o1) + " " + getRatio(o2));
                if(getRatio(o2) - getRatio(o1) > 0){
                    return 1;
                } else if (getRatio(o2) - getRatio(o1) == 0) {
                    return 0;
                } else{
                    return -1;
                }
            }
        };
        Arrays.sort(arr, comparator);
        System.out.println(Arrays.toString(arr));
        double totalValue = 0.0;
        int totalWeight = 0;
        for(Item knapsackItem : arr) {
            System.out.println(knapsackItem.toString());
            if(totalWeight + knapsackItem.weight <= weight){
                totalValue += knapsackItem.value;
                totalWeight += knapsackItem.weight;
            }else{
                totalValue += (weight - totalWeight) * getRatio(knapsackItem);
                break;  // break the loop as we have reached the weight limit.
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item item1 = new Item(8, 7);
        Item item2 = new Item(10, 1);
        Item item3 = new Item(2, 2);
        Item item4 = new Item(1, 8);
        Item item5 = new Item(10, 6);
        Item item6 = new Item(7, 6);
        Item item7 = new Item(1, 4);
        Item item8 = new Item(7, 8);
        Item item9 = new Item(9, 9);
        Item item10 = new Item(5, 7);
        Item[] arr = new Item[]{item1, item2, item3,
                item4, item5, item6,
                item7, item8, item9, item10
        };
        System.out.println(fractionalKnapsack(21, arr, arr.length));
    }

}
