/*
Give	an	algorithm	for	inserting	an	element	into	binary	tree.
*/
package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInBinaryTree {
    public TreeNode insert(TreeNode root, int value){
        TreeNode newNode = new TreeNode(value);
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                popped = queue.poll();

                if(popped.left != null){
                    queue.offer(popped.left);
                }else{
                    popped.left = newNode;
                    return root;
                }

                if(popped.right!= null){
                    queue.offer(popped.right);
                }else{
                    popped.right = newNode;
                    return root;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InsertInBinaryTree insertInBinaryTree = new InsertInBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);

        root = insertInBinaryTree.insert(root, 5);
        root = insertInBinaryTree.insert(root, 6);
        root = insertInBinaryTree.insert(root, 8);

        System.out.println(root);
    }
}
