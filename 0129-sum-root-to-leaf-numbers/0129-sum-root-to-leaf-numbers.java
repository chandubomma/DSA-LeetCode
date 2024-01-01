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
        int[] sum = new int[1];
        StringBuilder str = new StringBuilder();
        solve(root,sum,str);
        return sum[0];
    }
    
    public void solve(TreeNode root,int[] sum,StringBuilder str){
        if(root==null)return;
        str.append(Integer.toString(root.val));
        if(root.left==null && root.right==null){
            sum[0]+=Integer.parseInt(str.toString());
            str.delete(str.length()-1,str.length());
            return;
        }
        solve(root.left,sum,str);
        solve(root.right,sum,str);
        str.delete(str.length()-1,str.length());
        return;
    }
}