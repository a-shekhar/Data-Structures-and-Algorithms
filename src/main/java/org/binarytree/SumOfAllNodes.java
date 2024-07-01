package org.binarytree;

/*
Give an algorithm for finding the sum of all elements in binary tree
 */
public class SumOfAllNodes {
    static int sumBT(TreeNode root){
        //Code
        if(root == null){
            return 0;
        }
        return root.val + sumBT(root.left) + sumBT(root.right);
    }
}
