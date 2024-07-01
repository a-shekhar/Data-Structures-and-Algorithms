package org.binarytree;

import java.util.ArrayList;
import java.util.List;

// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// LeetCode - 94
public class InorderTransversal {
    ArrayList<Integer> inorderList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return inorderList;
        }
        inorderTraversal(root.left);
        inorderList.add(root.val);
        inorderTraversal(root.right);
        return inorderList;
    }
}
