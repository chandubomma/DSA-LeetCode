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
    public TreeNode bstToGst(TreeNode root) {
        GreaterTree(root,0);
        return root;
    }
    public int GreaterTree(TreeNode node,int sum){
        if(node==null)return 0;
        int right = GreaterTree(node.right,sum);
        node.val = node.val+right+(right==0?sum:0);
        int left = GreaterTree(node.left,node.val);
        return left==0?node.val:left;
    }
}