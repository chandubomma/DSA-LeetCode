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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        int left = 0,right=0;
        if(root.left!=null && root.left.left==null && root.left.right==null )                             left=root.left.val+sumOfLeftLeaves(root.left);
        else left = sumOfLeftLeaves(root.left);
        right = sumOfLeftLeaves(root.right);
        return left+right;
    }
}