package org.binarysearchtree;

import org.binarytree.TreeNode;

/*
Given the root of a Binary Search Tree.
 The task is to find the minimum valued element in this given BST.
*/
public class BSTMaxElementIterative {
    int maxValue(TreeNode root) {
        // code here
        int maxValue = -1;

        if(root == null) {
            return maxValue;
        }

        while(root != null) {
            maxValue = root.val;
            root = root.right;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        BSTMaxElementIterative maxElementIterative = new BSTMaxElementIterative();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode();
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(8);
        System.out.println(maxElementIterative.maxValue(root));
    }
}
