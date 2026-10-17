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
    private TreeNode build(int[] postorder, int[] inorder, int postL, int postR, int inL, int inR){
        if(postL>postR) return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int idx=inL;
        while(idx<=inR){
            if(inorder[idx]==root.val) break;
            idx++;
        }
        int leftNodes = idx-inL;
        root.left=build(postorder,inorder,postL,postL+leftNodes-1,inL,idx-1);
        root.right=build(postorder,inorder,postL+leftNodes,postR-1,idx+1,inR);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return build(postorder,inorder,0,n-1,0,n-1);
    }
}