/*
Give	an	algorithm	for	printing	the	level
order	data	in	reverse	order
*/
package org.binarytree;


import java.util.*;

public class LevelOrderReversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> reserveLevelOrder = new ArrayList<>();
        if(root == null){
            return reserveLevelOrder;
        }
        List<Integer> levelOrder;
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode popped;
        while(!queue.isEmpty()){
            levelOrder = new ArrayList<>();
            size = queue.size();
            for(int i = 0; i < size; i++){

                popped = queue.poll();
                assert popped != null;
                levelOrder.add(popped.val);
                if(popped.left!= null){
                    queue.offer(popped.left);
                }

                if(popped.right!= null){
                    queue.offer(popped.right);
                }
            }
            stack.push(levelOrder);
        }
        while(!stack.isEmpty()){
            reserveLevelOrder.add(stack.pop());
        }
        return reserveLevelOrder;
    }
}
