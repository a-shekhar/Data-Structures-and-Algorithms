package org.binarytree;



/*
Given the root of a binary tree,
return the zigzag level order traversal
of its nodes' values. (i.e., from left to right,
then right to left for the next level and alternate between).
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTransversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        boolean isLeftToRightTransversal =true;
        List<Integer> levelOrderTransversal;
        while(!queue.isEmpty()){
            size = queue.size();
            levelOrderTransversal = new ArrayList<>();
            for(int i = 0; i < size; i++){
                popped = queue.poll();
                levelOrderTransversal.add(popped.val);
                if(isLeftToRightTransversal){
                    if(popped.left != null){
                        queue.offer(popped.left);
                    }
                    if(popped.right!= null){
                        queue.offer(popped.right);
                    }
                }else{
                    if(popped.right != null){
                        queue.offer(popped.right);
                    }
                    if(popped.left!= null){
                        queue.offer(popped.left);
                    }
                }
            }
            result.add(levelOrderTransversal);
            System.out.println(isLeftToRightTransversal);
            isLeftToRightTransversal = !isLeftToRightTransversal;
        }
        return result;
    }
}
