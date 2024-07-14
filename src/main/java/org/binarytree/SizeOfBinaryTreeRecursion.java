/*

Give	an	algorithm	for	finding	the	size	of	binary	tree.
*/
package org.binarytree;

import com.sun.source.tree.Tree;

public class SizeOfBinaryTreeRecursion {

    public  int getSize(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public static void main(String[] args) {
        SizeOfBinaryTreeRecursion obj = new SizeOfBinaryTreeRecursion();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println("Size " + obj.getSize(root));
        root.right = new TreeNode(3);
        System.out.println("Size " + obj.getSize(root));
    }
}
