/*
 
Give	an	algorithm	for	searching	an	element	in	binary	tree	without	recursion.
 */
package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInBinaryTreeIterative {
    public boolean searchTree(TreeNode root, int target){
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                popped = queue.poll();
                if(popped.val == target){
                    return true;
                }
                if(popped.left!= null){
                    queue.offer(popped.left);
                }
                if(popped.right!= null){
                    queue.offer(popped.right);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInBinaryTreeIterative obj = new SearchInBinaryTreeIterative();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(15);
        System.out.println(obj.searchTree(root, 15));
        System.out.println(obj.searchTree(root, 10));
        System.out.println(obj.searchTree(root, 12));
    }
}
