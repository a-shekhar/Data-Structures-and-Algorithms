package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*Given a Binary Tree,
 find the maximum width of it. Maximum width is defined as the maximum number of nodes at any level.
 */
public class WidthOfBinaryTree {
    int getMaxWidth(TreeNode root) {
       int maxWidth = 0;
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        while(!queue.isEmpty()){
            size = queue.size();
            maxWidth = Math.max(size, maxWidth);
            for(int i = 0; i < size; i++){
                popped = queue.poll();
                if(popped.left!= null){
                    queue.offer(popped.left);
                }
                if(popped.right!= null){
                    queue.offer(popped.right);
                }
            }
        }
        return maxWidth;

    }
}
