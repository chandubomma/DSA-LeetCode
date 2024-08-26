/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        pot(root,list);
        return list;
    }
    
    public void pot(Node node,ArrayList<Integer> list){
        if(node==null)return;
        for(Node temp : node.children)pot(temp,list);
        list.add(node.val);
    }
}