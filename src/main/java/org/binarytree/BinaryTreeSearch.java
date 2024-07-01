package org.binarytree;

/* Give an algorithm for searching an element in binary search tree
*/
public class BinaryTreeSearch {
    TreeNode left;

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        left = searchBST(root.left, val);
        if(left == null){
            root = searchBST(root.right, val);
        }else{
            root = left;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeSearch binaryTreeSearch = new BinaryTreeSearch();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println("Found root: " + binaryTreeSearch.searchBST(root, 2));
    }
}
