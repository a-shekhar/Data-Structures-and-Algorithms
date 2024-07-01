package org.binarysearchtree;

import org.binarytree.TreeNode;

/*
Given the root of a Binary Search Tree.
 The task is to find the minimum valued element in this given BST.
*/
public class BSTMaxElement {

    int maxValue = -1;

    int maxValue(TreeNode root) {
        // code here
        if(root == null) {
            return maxValue;
        }

        if(root != null) {
            maxValue = root.val;
        }

        maxValue(root.right);

        return maxValue;
    }

    public static void main(String[] args) {
        BSTMaxElement maxElementIterative = new BSTMaxElement();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode();
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode();
        root.right.right.right = new TreeNode(8);


        System.out.println(maxElementIterative.maxValue(root));
    }
}
