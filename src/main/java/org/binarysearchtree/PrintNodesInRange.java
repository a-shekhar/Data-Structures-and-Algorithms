/*
Given a Binary Search Tree and a range [low, high].
Find all the numbers in the BST that lie in the given range.
Note: Element greater than or equal to root go to the right side.
 */
package org.binarysearchtree;

import org.binarytree.TreeNode;

import java.util.ArrayList;


public class PrintNodesInRange {
    // Add code here.
    // Return a list of all elements in the BST that lie in the given range.
    static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer> printNearNodes(TreeNode root, int low, int high) {
        // code here.
        if(root == null){
            return result;
        }
        // to optimise performance
        if(root.val > high){
            return result;
        }

        printNearNodes(root.left, low, high);

        if(root.val >= low && root.val <= high){
            result.add(root.val);
        }

        printNearNodes(root.right, low, high);
        return result;
    }
    // another way to solve is level order transversal and check node value
    // is in range
}
