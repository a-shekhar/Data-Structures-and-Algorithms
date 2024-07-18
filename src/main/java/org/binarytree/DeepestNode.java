package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
Give	an	algorithm	for	finding	the	deepest	node	of	the	binary	tree
 */
public class DeepestNode {
    public TreeNode deepestNode(TreeNode root){
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped = null;
        int minDepth = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            minDepth++;  // increment minDepth for each level.
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
        return popped;
    }

    public static void main(String[] args) {
        DeepestNode deepest = new DeepestNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(17);
        System.out.println(deepest.deepestNode(root));
    }
}
