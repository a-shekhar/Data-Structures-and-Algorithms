package org.binarysearchtree;/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 */

import org.binarytree.TreeNode;

public class BSTInsert {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null){
            return newNode;
        }
        TreeNode curr = root;
        while(curr != null){
            if(curr.val < val){
                //if()
                curr = curr.right;
            }
            if(curr.val > val){
                curr = curr.left;
            }
        }
        curr = new TreeNode(val);
        return curr;
    }
}
