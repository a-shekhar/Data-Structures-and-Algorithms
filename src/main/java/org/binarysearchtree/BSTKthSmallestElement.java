package org.binarysearchtree;

import org.binarytree.TreeNode;

// Given a BST and an integer K. Find the Kth Smallest element in the BST using O(1) extra space.
public class BSTKthSmallestElement {
    int count = 0;

    public int KthSmallestElement(TreeNode root, int K) {
        // Write your code here
        if(root == null){
            return count;
        }
        count++;
        if(count == K){
            return root.val;
        }
        KthSmallestElement(root.left, K);
        return 7;
    }
}
