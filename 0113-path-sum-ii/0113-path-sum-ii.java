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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> flist = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        solve(root,targetSum,0,flist,list);
        return flist;
    }
    
    public void solve(TreeNode root,int target,int sum,List<List<Integer>> flist,List<Integer> list){
        if(root==null)return;
        list.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(target==sum){
                flist.add(new ArrayList<Integer>(list));
            }
        }
        solve(root.left,target,sum,flist,list);
        solve(root.right,target,sum,flist,list);
        list.remove(list.size()-1);
        return;
    }
}