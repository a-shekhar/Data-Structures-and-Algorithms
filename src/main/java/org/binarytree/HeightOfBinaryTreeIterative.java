/*
Give	an	algorithm	for	finding	the	height	(or	depth)	of	the	binary	tree
 */
package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTreeIterative {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        int maxDepth = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            maxDepth++;  // increment maxDepth for each level.
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
        return maxDepth;
    }
}
