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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root!=null){
            q.offer(root);
        }
        List<Integer> res = new ArrayList<>();
        while(q.isEmpty() == false){
            int s=q.size();
            int n=0;
            while(s-- >0){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                n=node.val;
            }
            res.add(n);
        }
        return res;
    }
}