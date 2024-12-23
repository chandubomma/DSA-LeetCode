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
    public int minimumOperations(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int lvs,minSwaps=0;TreeNode node;
        while(q.size()>0){
            lvs = q.size();
            int[] arr = new int[lvs];
            for(int i=0;i<lvs;i++){
                node = q.poll();
                arr[i] = node.val;
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            minSwaps+=findMinSwaps(arr);
        }
        return minSwaps;
    }
    
    public int findMinSwaps(int[] arr){
        int swaps=0,minInd;
        for(int i=0;i<arr.length;i++){
            minInd=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minInd])minInd=j;
            }
            if(i!=minInd){
                swap(arr,i,minInd);
                swaps++;
            }
        }
        return swaps;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}