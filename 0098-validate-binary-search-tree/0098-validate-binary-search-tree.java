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
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        boolean ans = left && right ;
        if(root.left!=null){
             int max = findMax(root.left);
             ans = ans && root.val>max;
        }
        if(root.right!=null){
            int min = findMin(root.right);
            ans = ans && root.val<min;
        }
        return ans;
    }
    
    public int findMax(TreeNode node){
        int max = node.val;
        if(node.left!=null)max=Math.max(max,findMax(node.left));
        if(node.right!=null)max = Math.max(max,findMax(node.right));
        return max;
    }
    public int findMin(TreeNode node){
        int min = node.val;
        if(node.left!=null)min=Math.min(min,findMin(node.left));
        if(node.right!=null)min = Math.min(min,findMin(node.right));
        return min;
    }
}