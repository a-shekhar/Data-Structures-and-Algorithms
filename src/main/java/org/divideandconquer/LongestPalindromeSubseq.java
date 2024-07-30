package org.divideandconquer;
/*
Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s, 0, s.length() - 1);
    }

    private int longestPalindromeSubseq(String s, int left, int right) {
        if (left == right) {
            return 1;
        }
        if (left > right) {
            return 0;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return 2 + longestPalindromeSubseq(s, left + 1, right - 1);
        }
        int count2 = longestPalindromeSubseq(s, left, right-1);
        int count3 = longestPalindromeSubseq(s, left+1, right);
        return Math.max(count2, count3);
    }
}
