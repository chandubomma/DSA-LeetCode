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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        TreeNode p,c;
        for(int[] d : descriptions){
            if(map.get(d[0])==null)p = new TreeNode(d[0]);
            else p = map.get(d[0]);
            if(map.get(d[1])==null)c = new TreeNode(d[1]);
            else c = map.get(d[1]);
            if(d[2]==1)p.left = c;
            else p.right = c;
            map.put(d[0],p);
            map.put(d[1],c);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int[] d: descriptions){
            set.add(d[0]);
        }
        for(int[] d: descriptions){
            set.remove(d[1]);
        }
        ArrayList<Integer> root = new ArrayList<>(set);
        return map.get(root.get(0));
    }
}