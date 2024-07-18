/*
Give	an	algorithm	for	finding	the	minimum	depth	of	the	binary	tree
 */
package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthIterative {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        int minDepth = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            minDepth++;  // increment minDepth for each level.
            for(int i = 0; i < size; i++){
                popped = queue.poll();
                if(popped.left == null && popped.right == null){
                    return minDepth;
                }
                if(popped.left!= null){
                    queue.offer(popped.left);
                }
                if(popped.right!= null){
                    queue.offer(popped.right);
                }
            }
        }
        return minDepth;
    }
}
