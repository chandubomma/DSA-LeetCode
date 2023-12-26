class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n][n];
        for(int[] row : dp)Arrays.fill(row,0);
        return solve(1,n,dp);
    }
    
    public int solve(int l,int r,int[][] dp){
        if(l==r || l>r)return 1;
        if(dp[l-1][r-1]!=0)return dp[l-1][r-1];
        int sum=0;
        for(int i=l;i<=r;i++){
            sum+=solve(l,i-1,dp)*solve(i+1,r,dp);
        }
        return dp[l-1][r-1]=sum;
    }
}