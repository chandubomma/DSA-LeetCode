

 public class TreeNode {
     int val;
     String s; 
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    public String smallestFromLeaf(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        solve(root,list,"");
        Collections.sort(list);
        return list.get(0);
    }
    
    public void solve(TreeNode root,ArrayList<String> list,String s){
        if(root==null)return;
        StringBuilder sb = new StringBuilder(s);
        sb.append((char)('a'+root.val));
        root.s = sb.toString();
        if(root.left==null && root.right==null){
            list.add(sb.reverse().toString());
            return;
        }
        solve(root.left,list,root.s);
        solve(root.right,list,root.s);
    }
}