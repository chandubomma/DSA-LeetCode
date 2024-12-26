class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] ans = new int[1];
        solve(nums,0,target,0,ans);
        return ans[0];
    }
    
    public void solve(int[] nums,int n,int target,int currSum,int[] ans){
        if(n==nums.length){
            if(currSum==target)ans[0]++;
            return;
        }
        solve(nums,n+1,target,currSum+nums[n],ans);
        solve(nums,n+1,target,currSum-nums[n],ans);
    }
}