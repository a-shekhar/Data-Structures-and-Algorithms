package org.binarytree;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.
*/
//TODO
public class RootToLeafPaths {
    List<String> paths = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return paths;
        }
        if(root.left == null && root.right == null){
            paths.add(String.valueOf(root.val));
            return paths;
        }else{
            paths.add(root.val + "->");
        }
        binaryTreePaths(root.left);
        binaryTreePaths(root.right);
        return paths;
    }
}
