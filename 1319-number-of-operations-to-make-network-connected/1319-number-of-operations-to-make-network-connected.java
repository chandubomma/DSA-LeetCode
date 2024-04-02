class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges<n-1)return -1;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<edges;i++){
            ds.unionBySize(connections[i][0],connections[i][1]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i)count++;
        }
        if(count==1)return 0;
        return count-1;
    }
}

class DisjointSet{
    int[] parent;
    int[] size;
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++)parent[i]=i;
    }
    
    public int findParent(int i){
        if(parent[i]==i)return i;
        return parent[i]=findParent(parent[i]);
    }
    
    public void unionBySize(int u,int v){
        int upu = findParent(u);
        int upv = findParent(v);
        if(upu==upv)return;
        if(size[upu]<size[upv]){
            parent[upu]=upv;
            size[upv]+=size[upu];
        }else{
            parent[upv]=upu;
            size[upu]+=size[upv];
        }
    }
}