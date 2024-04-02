class Solution {
    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(i,new ArrayList<>());
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int count=0;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                count++;
                dfs(i,adj,vis);
            }
        }
        if(count==1)return 0;
        int edges = connections.length;
        if(edges<n-1)return -1;
        return count-1;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        for(int i: adj.get(node)){
            if(!vis[i]){
                vis[i]=true;
                dfs(i,adj,vis);
            }
        }
    }
}