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
    private TreeNode build(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
        if(preL>preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int idx=inL;
        while(idx<=inR){
            if(inorder[idx]==root.val) break;
            idx++;
        }
        int leftNodes = idx-inL;
        root.left=build(preorder,inorder,preL+1,preL+leftNodes,inL,idx-1);
        root.right=build(preorder,inorder,preL+leftNodes+1,preR,idx+1,inR);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        return build(preorder,inorder,0,n-1,0,n-1);
    }
}