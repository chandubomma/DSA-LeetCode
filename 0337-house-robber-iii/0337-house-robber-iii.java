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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> dp = new HashMap<>();
        return solve(root,dp);
    }
    
    public int solve(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null)return 0;
        int taken = root.val;
        if(dp.get(root)!=null)return dp.get(root);
        if(root.left!=null){
            taken += solve(root.left.left,dp);
            taken += solve(root.left.right,dp);
        }
        if(root.right!=null){
            taken += solve(root.right.left,dp);
            taken += solve(root.right.right,dp);
        }
        int notTaken = 0;
        notTaken += solve(root.left,dp);
        notTaken += solve(root.right,dp);
        dp.put(root,Math.max(taken,notTaken));
        return Math.max(taken,notTaken);
    }
    
}