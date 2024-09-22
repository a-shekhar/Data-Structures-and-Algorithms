package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class FindMinAndMax {
    static int findSingle(int n, int arr[]){
        // code here
        int single = arr[0];
        for(int i = 1; i < n; i++){
            single ^= arr[i];
        }
        return single;
    }

    public static void main(String[] args) {


    }
}
