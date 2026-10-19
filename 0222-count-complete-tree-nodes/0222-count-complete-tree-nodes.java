/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int leftHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + leftHeight(root.left);
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int l = leftHeight(root.left);
        int r = leftHeight(root.right);
        if(l==r){   //left subtree is perfect
            return (1<<l) + countNodes(root.right);
        }
        else{
            return (1<<r) + countNodes(root.left);
        }
    }
}