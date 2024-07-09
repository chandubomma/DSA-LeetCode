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
    public int deepestLeavesSum(TreeNode root) {
        int[] maxLevel = new int[1];
        int[] sum  = new int[1];
        dfs(root,0,maxLevel,sum);
        return sum[0];
    }
    
    public void dfs(TreeNode node,int currLevel,int[] maxLevel,int[] sum){
        if(node==null) return;
        if(node.left==null && node.right==null){
            if(currLevel==maxLevel[0]){
                sum[0]+=node.val;
            }
            else if(currLevel>maxLevel[0]){
                sum[0]=node.val;
                maxLevel[0]=currLevel;
            }
        }
        dfs(node.left,currLevel+1,maxLevel,sum);
        dfs(node.right,currLevel+1,maxLevel,sum);
    }
}