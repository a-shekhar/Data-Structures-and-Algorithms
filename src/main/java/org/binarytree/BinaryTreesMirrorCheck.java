package org.binarytree;

/*
Given a Two Binary Trees, write a function that returns true
if one is mirror of other, else returns false.
 */
public class BinaryTreesMirrorCheck {
    boolean areMirror(TreeNode root1, TreeNode root2) {
        // Your code here
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && areMirror(root1.left, root2.right) && areMirror(root1.right, root2.left);
    }
}
