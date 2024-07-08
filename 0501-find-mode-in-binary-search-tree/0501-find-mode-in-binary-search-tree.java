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
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int max = Integer.MIN_VALUE;
        traverse(root,freq);
        for(int i : freq.values()){
            max = Math.max(i,max);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : freq.keySet()){
            if(freq.get(i)==max)list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void traverse(TreeNode root,HashMap<Integer,Integer> freq){
        if(root==null)return;
        freq.put(root.val,freq.getOrDefault(root.val,0)+1);
        traverse(root.left,freq);
        traverse(root.right,freq);
    }
}