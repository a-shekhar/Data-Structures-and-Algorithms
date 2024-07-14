
/*

Give	an	algorithm	for	finding	maximum	, minimum
element	in	binary	tree	without	recursion.
*/

package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxMinIterative {
    int minElement = Integer.MAX_VALUE;
    int maxElement = Integer.MIN_VALUE;

    public void levelOrderTransversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                popped = queue.poll();
                minElement = Math.min(popped.val, minElement);
                maxElement = Math.max(popped.val, maxElement);
                if(popped.left != null){
                    queue.offer(popped.left);
                }
                if(popped.right != null){
                    queue.offer(popped.right);
                }
            }
        }
    }

    public int findMax(TreeNode root){
        //code here
        levelOrderTransversal(root);
        return maxElement;
    }
    public int findMin(TreeNode root){
        //code here
        levelOrderTransversal(root);
        return minElement;
    }

    public static void main(String[] args) {
        FindMaxMinIterative maxMinIterative = new FindMaxMinIterative();
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(4);
        System.out.println("max element " + maxMinIterative.findMax(root));
        System.out.println("min element " + maxMinIterative.findMin(root));
    }
}
