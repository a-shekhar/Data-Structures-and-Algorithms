package org.divideandconquer;
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    public int longestCommonSubsequence(String text1, String text2, int index1, int index2) {
        if(index1 == text1.length() || index2 == text2.length()){
            return 0;
        }
        int count1 = 0;
        if(text1.charAt(index1) == text2.charAt(index2)){
            count1 = 1 + longestCommonSubsequence(text1, text2, index1 + 1, index2 + 1);
        }
        int count2 = longestCommonSubsequence(text1, text2, index1+1, index2);
        int count3 = longestCommonSubsequence(text1, text2, index1, index2+1);
        return Math.max(count1, Math.max(count2, count3));
    }
}
