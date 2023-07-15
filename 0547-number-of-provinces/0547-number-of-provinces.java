class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)list.add(new ArrayList<>());
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(j!=i && isConnected[i][j]==1)list.get(i).add(j);
            }
        }
        boolean[] isVisited = new boolean[isConnected.length];
        Arrays.fill(isVisited,false);int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!isVisited[i]){
                count++;
                dfs(i,list,isVisited);
            }
        }
        return count;
        
    }
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> list,boolean[] isVisited){
        isVisited[node]=true;
        ArrayList<Integer> list2 = list.get(node);
        for(int i : list2){
            if(!isVisited[i])dfs(i,list,isVisited);
        }
            
    }
}