package org.arrays;

public class Test {
    private static String convertToBinary(int value) {
        String result = "";
        while (value > 0){
            result = (value % 2) + result;
            value /= 2;
        }
        return result;
    }
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        String result = "";
        for(String part : parts) {
            result += convertToBinary(Integer.valueOf(part)) + "-";
        }
        result = result.substring(0, result.length() - 1);  // remove trailing hyphen
        return result;
    }

    public static void main(String[] args) {
        Test obj = new Test();
        System.out.println(obj.convertDateToBinary("2080-02-29"));
    }
}
