/*
Given a Binary Tree of size N, You have to count leaves in it.
 */
package org.binarytree;

public class NoOfLeaves {
    public int countLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }
}
