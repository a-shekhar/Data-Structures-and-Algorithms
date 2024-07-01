package org.binarytree;/*
Given a Binary Tree having positive and negative nodes.
Find the maximum sum of a level in the given Binary Tree.
*/

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        // add code here.
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int size = 0;
        TreeNode removedNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            size = queue.size();
            sum = 0;  // reset sum for each level.
            for(int i = 0; i < size; i++){
                removedNode = queue.poll();
                sum += removedNode.val;
                if(removedNode.left != null){
                    queue.offer(removedNode.left);
                }
                if(removedNode.right != null){
                    queue.offer(removedNode.right);
                }
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxLevelSum maxLevelSum = new MaxLevelSum();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.right.right = new TreeNode(6);
        System.out.println(maxLevelSum.maxLevelSum(root));
    }
}
