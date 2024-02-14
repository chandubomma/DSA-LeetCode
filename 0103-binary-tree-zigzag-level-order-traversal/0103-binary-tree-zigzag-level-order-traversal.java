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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> flist = new ArrayList<>();
        if(root==null)return flist;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int t=0,currentLevelSize;
        TreeNode node;
        while(!dq.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            currentLevelSize = dq.size();
            while(currentLevelSize-->0){
                if(t%2==0){
                    node=dq.removeFirst();
                    list.add(node.val);
                    if(node.left!=null)dq.offerLast(node.left);
                    if(node.right!=null)dq.offerLast(node.right);
                }else{
                    node=dq.removeLast();
                    list.add(node.val);
                    if(node.right!=null)dq.offerFirst(node.right);
                    if(node.left!=null)dq.offerFirst(node.left);
                }
            }
            t++;
            flist.add(list);
        }
        return flist;
    }
}