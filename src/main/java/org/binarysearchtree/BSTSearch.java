package org.binarysearchtree;

import org.binarytree.TreeNode;

/* Give an algorithm for searching an element in binary search tree
* Leetcode-700
*  */
public class BSTSearch {
    // T.C - O(log n)
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }

        if(root.val < val){
            root = searchBST(root.right, val);
        }else {
            root = searchBST(root.left, val);
        }

        return root;
    }

    public static void main(String[] args) {
        BSTSearch bstSearch = new BSTSearch();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println("Found root: " + bstSearch.searchBST(root, 5));
    }
}
