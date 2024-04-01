class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(i,new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[]  vis = new boolean[numCourses];
        boolean[]  pathVis = new boolean[numCourses];
        Arrays.fill(vis,false);
        Arrays.fill(pathVis,false);
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                vis[i]=pathVis[i]=true;
                if(dfs(i,adj,vis,pathVis))return false;
                pathVis[i]=false;
            }
        }
        return true;
    }
    
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] pathVis) {
        for(int i : adj.get(node)){
            if(!vis[i]){
                vis[i]=true;
                pathVis[i]=true;
                if(dfs(i,adj,vis,pathVis))return true;
                pathVis[i]=false;
            }else if(vis[i] && pathVis[i])return true;
        }
        return false;
    }
}