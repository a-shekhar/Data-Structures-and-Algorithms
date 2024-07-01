package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
Give an algorithm for finding the sum of all elements in binary tree
 */
public class SumOfAllNodesIterative {
    static int sumBT(TreeNode root){
        //Code
        if(root == null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int size;
        TreeNode popped;
        queue.offer(root);
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                popped = queue.poll();
                sum += popped.val;
                if(popped.left!= null){
                    queue.offer(popped.left);
                }
                if(popped.right != null){
                    queue.offer(popped.right);
                }
            }
        }
        return sum;
    }
}
