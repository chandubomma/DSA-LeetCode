class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] dp = new int[m][n];
        return solve(0,0,m,n,dp,grid);
    }
    
    public int solve(int i,int j,int m,int n,int[][] dp,int[][] grid){
        if(i>=m || j>=n) return 200*200*200+1;
        if(i==m-1 && j==n-1)return grid[i][j];
        if(dp[i][j]!=0)return dp[i][j];
        int right =solve(i,j+1,m,n,dp,grid);
        int bottom = solve(i+1,j,m,n,dp,grid);
        dp[i][j] = Math.min(grid[i][j]+right,grid[i][j]+bottom);
        return dp[i][j];
    }
}