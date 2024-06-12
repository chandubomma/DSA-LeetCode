class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int[][] dp = new int[rewardValues.length][4000];
        return solve(rewardValues,0,0,dp);
    }
    
    public int solve(int[] arr,int n,int sum,int[][] dp){
        if(n==arr.length-1){
            if(arr[n]>sum)sum+=arr[n];
            return dp[n][sum]=sum; 
        }
        if(dp[n][sum]!=0)return dp[n][sum];
        int taken=0;
        if(arr[n]>sum){
            taken = solve(arr,n+1,sum+arr[n],dp);
        }
        int notTaken = solve(arr,n+1,sum,dp);
        dp[n][sum]=Math.max(taken,notTaken);
        return dp[n][sum];
    }
}