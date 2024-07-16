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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root==null)return new String();
        TreeNode sv=null,dv=null;
        if(root.val!=startValue){
             sv = search(root.left,startValue);
        }
         if(root.val!=destValue){
             dv = search(root.left,destValue);
        }
        if(root.val!=startValue && root.val!=destValue){
            if(sv==null && dv==null) return getDirections(root.right,startValue,destValue);
            if(sv!=null && dv!=null)return getDirections(root.left,startValue,destValue);
        }
        StringBuilder svs = new StringBuilder();
        StringBuilder fsvs = new StringBuilder();
        StringBuilder dvs = new StringBuilder();
        if(root.val==startValue){
            if(dv!=null){
                    dvs.append('L');
                    getPath(root.left,destValue,dvs);
               }else{
                    dvs.append('R');
                    getPath(root.right,destValue,dvs);
               }
            
        }else if(root.val==destValue){
            if(sv!=null){
                 svs.append('L');
                getPath(root.left,startValue,svs);
                for(int i=0;i<svs.length();i++)fsvs.append('U');
            }else{
                svs.append('R');
                getPath(root.right,startValue,svs);
                for(int i=0;i<svs.length();i++)fsvs.append('U');
            }
        }
        else{
            if(sv!=null){
                svs.append('L');
                getPath(root.left,startValue,svs);
                for(int i=0;i<svs.length();i++)fsvs.append('U');
                dvs.append('R');
                getPath(root.right,destValue,dvs);
            }else{
                svs.append('R');
                getPath(root.right,startValue,svs);
                for(int i=0;i<svs.length();i++)fsvs.append('U');
                dvs.append('L');
                getPath(root.left,destValue,dvs);
            }
        }
        return fsvs.append(dvs).toString();
    }
    
    public boolean getPath(TreeNode root,int val,StringBuilder str){
        if(root==null)return false;
        if(root.val==val)return true;
        boolean left=false;
        if(root.left!=null){
            str.append('L');
            left =  getPath(root.left,val,str);
            if(left)return left;
            str.delete(str.length()-1,str.length());
        }
       if(root.right!=null){
           str.append('R');
           left =  getPath(root.right,val,str);
           if(!left)
           str.delete(str.length()-1,str.length());
       }
        return left;
    }
    
    public TreeNode search(TreeNode root,int val){
        if(root==null)return null;
        if(root.val==val)return root;
        TreeNode node;
        node = search(root.left,val);
        if(node!=null)return node;
        return search(root.right,val);
    }
}