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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        solve(root,val,depth,1);
        return root;
    }
    
    public void solve(TreeNode root,int val,int depth,int currdepth){
       if(root==null)return;
       if(currdepth==depth-1){
           TreeNode left,right;
           left = root.left;
           right = root.right;
           root.left = new TreeNode(val);
           root.right = new TreeNode(val);
           root.left.left = left;
           root.right.right = right;
           return;
       }
        solve(root.left,val,depth,currdepth+1);
        solve(root.right,val,depth,currdepth+1);
    }
}