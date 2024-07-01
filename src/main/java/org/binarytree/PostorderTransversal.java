package org.binarytree;/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.
LeetCode-145
 */
import java.util.ArrayList;
import java.util.List;

public class PostorderTransversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
}
