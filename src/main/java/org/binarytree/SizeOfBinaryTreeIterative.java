/*

Give	an	algorithm	for	finding	the	size	of	binary	tree.
*/
package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTreeIterative {

    public  int getSize(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        int queueSize;
        TreeNode popped;
        while(!queue.isEmpty()){
            queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                popped = queue.poll();
                size++;
                if(popped.left!= null){
                    queue.offer(popped.left);
                }
                if(popped.right!= null){
                    queue.offer(popped.right);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        SizeOfBinaryTreeIterative obj = new SizeOfBinaryTreeIterative();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println("Size " + obj.getSize(root));
        root.right = new TreeNode(3);
        System.out.println("Size " + obj.getSize(root));
        root.right.left = new TreeNode(4);
        System.out.println("Size " + obj.getSize(root));
    }
}
