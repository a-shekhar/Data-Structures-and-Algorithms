package org.binarytree;/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 LeetCode-102
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTransversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level;
        queue.offer(root);
        while(!queue.isEmpty()){
            level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode popped = queue.poll();
                level.add(popped.val);
                if(popped.left != null){
                    queue.offer(popped.left);
                }
                if(popped.right != null){
                    queue.offer(popped.right);
                }
            }
            result.add(new ArrayList<>(level));
        }
        return result;
    }
}
