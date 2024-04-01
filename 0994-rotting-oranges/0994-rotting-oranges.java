class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Triple> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(boolean[] row:vis)Arrays.fill(row,false);
        int row,col,time=0,ftime=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2 && !vis[i][j] ){
                    q.offer(new Triple(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
         while(!q.isEmpty()){
                        row = q.peek().i;
                        col = q.peek().j;
                        time = q.peek().t;
                        q.remove();
                        if(row+1<grid.length && grid[row+1][col]==1 && !vis[row+1][col]){
                            q.offer(new Triple(row+1,col,time+1));
                            vis[row+1][col]=true;
                        }
                        if(row-1>=0 && grid[row-1][col]==1 && !vis[row-1][col]){
                            q.offer(new Triple(row-1,col,time+1));
                            vis[row-1][col]=true;
                        }
                        if(col+1<grid[row].length && grid[row][col+1]==1 && !vis[row][col+1]){
                            q.offer(new Triple(row,col+1,time+1));
                            vis[row][col+1]=true;
                        }
                         if(col-1>=0 && grid[row][col-1]==1 && !vis[row][col-1]){
                            q.offer(new Triple(row,col-1,time+1));
                            vis[row][col-1]=true;
                        }
                        ftime = Math.max(ftime,time);
                    }
                   
         for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]==1 && !vis[i][j])return -1;
                }
            }
         return ftime;
    }
    
    
    class Triple{
        int i;
        int j;
        int t;
        public Triple(int i,int j,int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
}