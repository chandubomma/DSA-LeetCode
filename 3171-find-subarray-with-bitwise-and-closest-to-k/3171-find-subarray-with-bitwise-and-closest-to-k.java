class Solution {
    public int minimumDifference(int[] nums, int k) {
        SegmentTree st = new SegmentTree();
        st.constructTree(nums);
        int i=0,j=0,and,ans=Integer.MAX_VALUE;
        while(i<nums.length && j<nums.length){
            if(i>j)j=i;
            and = st.query(i,j);
            ans=Math.min(ans,Math.abs(k-and));
            if(and<k)i++;
            else j++;
        }
        return ans;
    }
}

class SegmentTree{
    Node root;
    
    public void constructTree(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }
    
    private Node constructTree(int[] arr,int start,int end){
        Node node = new Node(start,end);
        if(start==end){
            node.data = arr[start];
            return node;
        };
        int mid = (start+end)/2;
        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);
        node.data = node.left.data & node.right.data;
        return node;
    }
    
    public int query(int start,int end){
        return query(root,start,end);
    }
    
    private int query(Node node,int start,int end){
        if(node==null || start>node.end || end < node.start)return ~0;
        if(start<=node.start && end>=node.end)return node.data;
        return query(node.left,start,end)&query(node.right,start,end);
    }
    
    class Node{
        int start;
        int end;
        int data;
        Node left;
        Node right;
        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}