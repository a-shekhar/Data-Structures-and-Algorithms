package org.binarysearchtree;

import org.binarytree.TreeNode;

/*
Given the root of a Binary Search Tree.
 The task is to find the minimum valued element in this given BST.
*/
public class BSTMinElement {

    int minValue = -1;

    int minValue(TreeNode root) {
        // code here
        if(root == null) {
            return minValue;
        }

        if(root != null) {
            minValue = root.val;
        }
        minValue(root.left);
        return minValue;
    }
}
