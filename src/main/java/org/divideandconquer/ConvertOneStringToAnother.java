package org.divideandconquer;
/* Given two string, find minimum operations to convert one string to another */
public class ConvertOneStringToAnother {
    public static  int getMinOperations(String str1, String str2, int index1, int index2){
        if(index1 == str1.length()){
            return str2.length() - index2;
        }
        if(index2 == str2.length()){
            return str1.length() - index1;
        }

        if(str1.charAt(index1) == str2.charAt(index2)){
            return getMinOperations(str1, str2, index1 + 1, index2 + 1);
        }
        int deleteOp = 1 + getMinOperations(str1, str2, index1 + 1, index2);
        int insertOp = 1 + getMinOperations(str1, str2, index1, index2 + 1);
        int replaceOp = 1 + getMinOperations(str1, str2, index1 + 1, index2 + 1);
        return Math.min(Math.min(deleteOp, insertOp), replaceOp);  // Return the minimum of three operations.
    }

    public static int minOperations(String str1, String str2) {
        return getMinOperations(str1, str2, 0, 0);
    }

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";
        System.out.println("Minimum operations: " + minOperations(str1, str2)); // Output: 3
    }
}
