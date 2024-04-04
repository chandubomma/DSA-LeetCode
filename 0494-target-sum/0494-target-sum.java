class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] ans = new int[1];
        solve(nums.length-1,target,nums,ans);
        return ans[0];
    }
    
    public void solve(int n,int target,int[] nums,int[] ans){
        if(n==0){
            if(target-nums[0]==0)ans[0]++;
            if(target+nums[0]==0)ans[0]++;
            return;
        }
        solve(n-1,target+nums[n],nums,ans);
        solve(n-1,target-nums[n],nums,ans);
    }
 }