/*
Give	an	algorithm	for	finding	the	number	of	half	nodes	(nodes	with	only	one
 child)	in	the	binary	tree	without	using	recursion
 */
package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CountHalfNodesIterative {
    public int countHalfNodes(TreeNode root) {

            if(root == null){
                return 0;
            }
            int count = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int size;
            TreeNode popped;
            while(!queue.isEmpty()){
                size = queue.size();
                for(int i = 0; i < size; i++){
                    popped = queue.poll();
                    if(popped.left!= null && popped.right == null){
                        count++;
                    }else if(popped.left == null && popped.right != null){
                        count++;
                    }
                    if(popped.left!= null){
                        queue.offer(popped.left);
                    }
                    if(popped.right!= null){
                        queue.offer(popped.right);
                    }
                }
            }
            return count;
    }

    public static void main(String[] args) {
        CountHalfNodesIterative obj = new CountHalfNodesIterative();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(11);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(4);

        System.out.println(obj.countHalfNodes(root));
    }
}
