/*
Give	an	algorithm	for	finding	maximum	, minimum
element	in	binary	tree.
*/
package org.binarytree;

public class FindMaxMinRecursion {
    int minElement = Integer.MAX_VALUE;
    int maxElement = Integer.MIN_VALUE;

    public int findMax(TreeNode root){
        //code here
        if(root == null) {
            return maxElement;
        }
        findMax(root.left);
        maxElement = Math.max(root.val, minElement);
        findMax(root.right);
        return maxElement;
    }
    public int findMin(TreeNode root){
        //code here
        if(root == null) {
            return minElement;
        }
        findMin(root.left);
        minElement = Math.min(root.val, minElement);
        findMin(root.right);
        return minElement;
    }
}
