/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        int lvlSize;
        if(root!=null)q.offer(root);
        Node node;
        while(!q.isEmpty()){
            lvlSize = q.size();
            for(int i=0;i<lvlSize-1;i++){
                node = q.poll();
                node.next = q.peek();
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            node = q.poll();
            node.next = null;
            if(node.left!=null)q.offer(node.left);
            if(node.right!=null)q.offer(node.right);
        }
        return root;
    }
}