package org.binarysearchtree;

import org.binarytree.TreeNode;

/*
Given the root of a Binary Search Tree.
 The task is to find the minimum valued element in this given BST.
*/
public class BSTMinElementIterative {
    int minValue(TreeNode root) {
        int minValue = -1;
        // code here
        if(root == null) {
            return minValue;
        }

        while(root != null) {
            minValue = root.val;
            root = root.left;
        }
        return minValue;
    }
}
