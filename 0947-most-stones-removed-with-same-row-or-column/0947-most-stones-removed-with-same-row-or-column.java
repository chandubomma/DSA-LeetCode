class Solution {
    public int removeStones(int[][] stones) {
        int max = 0;
        for(int i=0;i<stones.length;i++){
            for(int j=0;j<stones[i].length;j++){
                if(stones[i][j]>max)max=stones[i][j];
            }
        }
        boolean[][] vis = new boolean[max+1][max+1];
        boolean[][] mat = new boolean[max+1][max+1];
        for(int i=0;i<stones.length;i++){
               mat[stones[i][0]][stones[i][1]]=true;
        }
        int comp=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] && !vis[i][j]){
                    vis[i][j]=true;
                    comp++;
                    dfs(i,j,mat,vis);
                }
            }
        }
        
        return stones.length-comp;
    }
    
    public void dfs(int x,int y,boolean[][] mat,boolean[][] vis){
        for(int i=0;i<mat.length;i++){
            if(!vis[i][y] && mat[i][y]){
                vis[i][y]=true;
                dfs(i,y,mat,vis);
            }
        }
        for(int j=0;j<mat[0].length;j++){
            if(!vis[x][j] && mat[x][j]){
                vis[x][j]=true;
                dfs(x,j,mat,vis);
            }
        }
    }
    
}