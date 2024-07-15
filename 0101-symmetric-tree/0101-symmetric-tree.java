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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        invert(root.right);
        return checkTree(root.left,root.right);
    }
    
    public boolean checkTree(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;
        if(root1.val!=root2.val)return false;
        return checkTree(root1.left,root2.left)&&checkTree(root1.right,root2.right);
    }
    
    public void invert(TreeNode root){
        if(root==null)return;
        invert(root.left);
        invert(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }
}