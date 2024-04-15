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
    public int sumNumbers(TreeNode root) {
        StringBuilder num = new StringBuilder("");
        int[] ans = new int[1];
        solve(root,ans,num);
        return ans[0];
    }
    
    public void solve(TreeNode node,int[] ans,StringBuilder num){
        if(node==null)return;
        num.append(Integer.toString(node.val));
        if(node.left==null && node.right==null){
            if(num.length()==0)return;
            ans[0]+=Integer.parseInt(num.toString());
            num.delete(num.length()-1,num.length());
            return;
        }
        solve(node.left,ans,num);
        solve(node.right,ans,num);
        num.delete(num.length()-1,num.length());
    }
}