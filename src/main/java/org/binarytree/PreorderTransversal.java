package org.binarytree;/* Given the root of a binary tree, return the preorder traversal of its nodes' values.
LeetCode-144
*/
import java.util.ArrayList;
import java.util.List;

public class PreorderTransversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }
}
