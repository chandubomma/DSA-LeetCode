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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxVal,lvs;
        TreeNode node;
        while(q.size()>0){
            lvs = q.size();
            maxVal = Integer.MIN_VALUE;
            for(int i=0;i<lvs;i++){
                node = q.poll();
                maxVal = Math.max(maxVal,node.val);
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            list.add(maxVal);
        }
        return list;
    }
}