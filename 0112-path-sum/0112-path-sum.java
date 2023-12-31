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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        if(root.left==null && root.right==null){
            if(root.val==targetSum)return true;
            else return false;
        }
        if(root.left==null)return check(root.right,targetSum,root.val);
        if(root.right==null)return check(root.left,targetSum,root.val);
        return check(root,targetSum,0);
    }
    public boolean check(TreeNode root,int target,int sum){
        if(root==null)return false;
        if(root.left==null && root.right==null){
            if(target==sum+root.val)return true;
            return false;
        }
        boolean left = check(root.left,target,sum+root.val);
        if(!left && root.right!=null)return check(root.right,target,sum+root.val);
        return left;
    }
}