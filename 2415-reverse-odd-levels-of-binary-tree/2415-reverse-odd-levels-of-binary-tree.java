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
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        Queue<TreeNode> q = new LinkedList<>();
        dq.offer(root);int lvs,l=0;TreeNode node,curr=null;
        while(dq.size()>0){
            lvs = dq.size();int s=0;
            for(int i=0;i<lvs;i++){
                node = (l%2==0)?dq.removeFirst():dq.removeLast();
                if(l%2==0){
                    if(node.left!=null)dq.offer(node.left);
                    if(node.right!=null)dq.offer(node.right);
                }else{
                    if(node.right!=null)dq.addFirst(node.right);
                    if(node.left!=null)dq.addFirst(node.left);
                }
                if(q.size()>0){
                    if(s==0)curr=q.poll();
                }
                if(curr!=null && s==0){
                    curr.left=node;
                }
                if(curr!=null && s==1){
                    curr.right=node;
                    s=-1;
                    curr=null;
                }
                s++;
                q.offer(node);
            }
            l++;
        }
        return root;
    }
}