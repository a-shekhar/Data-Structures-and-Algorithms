/*
Give	an	algorithm	for	finding	the	number	of	full	nodes	in	the	binary	tree
 */
package org.binarytree;

public class CountFullNodes {
    public int countFullNode(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null || root.right == null){
            return 0;
        }
        return 1 + countFullNode(root.left) + countFullNode(root.right);
    }

    public static void main(String[] args) {
        CountFullNodes fullNodes = new CountFullNodes();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(fullNodes.countFullNode(root)); // Output: 2
    }
}
