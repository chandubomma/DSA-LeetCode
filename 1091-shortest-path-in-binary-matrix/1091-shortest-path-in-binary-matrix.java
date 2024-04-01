class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> pq = new LinkedList<>();
        int[][] d = new int[grid.length][grid.length];
        for(int[] row:d)Arrays.fill(row,Integer.MAX_VALUE);
        if(grid[0][0]==0){
            pq.offer(new Pair(0,0));
            d[0][0]=1;
        }
        int[] arr = {-1,0,1};int row,col;
        while(!pq.isEmpty()){
            row=pq.peek().row;
            col=pq.peek().col;
            pq.remove();
            for(int r1 : arr){
                for(int c1 : arr){
                    if(row+r1>=0 && row+r1<grid.length && col+c1>=0 && col+c1<grid.length){
                        if(grid[row+r1][col+c1]==0){
                            if(d[row][col]+1<d[row+r1][col+c1]){
                                d[row+r1][col+c1]=d[row][col]+1;
                                pq.offer(new Pair(row+r1,col+c1));
                            }
                        }
                    }
                }
            }
        }
        if(d[grid.length-1][grid.length-1]==Integer.MAX_VALUE)return -1;
        return d[grid.length-1][grid.length-1];
    }
    
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
}