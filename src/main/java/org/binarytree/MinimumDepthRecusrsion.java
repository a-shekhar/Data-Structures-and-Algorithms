/*
Give	an	algorithm	for	finding	the	minimum	depth	of	the	binary	tree
 */
package org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//TODO
public class MinimumDepthRecusrsion {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        return 1 + minDepth(root.left) + minDepth(root.right);
    }
}
