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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> finalList = new ArrayList<>();
        if(root==null)return finalList;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node;
        q.offer(root);
        int levelSize;
        while(!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            levelSize=q.size();
            while(levelSize-->0){
                node = q.poll();
                list.add(node.val);
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            finalList.add(list);
        }
        return finalList;
    }
}