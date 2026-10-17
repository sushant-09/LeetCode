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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.offer(root);
        boolean reverse = false;
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<s; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(reverse){
                Collections.reverse(level);
            }
            reverse = !reverse;
            res.add(level);
        }
        return res;
    }
}