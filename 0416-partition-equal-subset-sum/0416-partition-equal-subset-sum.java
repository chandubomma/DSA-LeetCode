class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum =0;
        for(int i:nums)totalSum+=i;
        if(totalSum%2==1)return false;
        Boolean [][] dp = new Boolean[nums.length][totalSum/2+1];
        return solve(nums.length-1,totalSum/2,nums,dp);
    }
    public boolean solve(int n,int targetSum,int[] nums,Boolean[][] dp){
        if(n==0){
            if(nums[0]==targetSum)return true;
            return false;
        }
        if(dp[n][targetSum]!=null)return dp[n][targetSum];
        boolean notTaken = solve(n-1,targetSum,nums,dp);
        boolean taken = false;
        if(nums[n]<=targetSum){
            taken = solve(n-1,targetSum-nums[n],nums,dp);
        }
        return dp[n][targetSum]=(taken|notTaken);
    }
}