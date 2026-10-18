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
    private void dfs(TreeNode root, int k, PriorityQueue<Integer> pq){
        if(root == null) return;
        pq.offer(root.val);
        if(pq.size()>k){
            pq.poll();
        }
        dfs(root.left,k,pq);
        dfs(root.right,k,pq);
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        dfs(root,k,pq);
        return pq.peek();
    }
}