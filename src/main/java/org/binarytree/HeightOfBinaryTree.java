/*
Give	an	algorithm	for	finding	the	height	(or	depth)	of	the	binary	tree
 */
package org.binarytree;

public class HeightOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
