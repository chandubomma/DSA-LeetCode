class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
       int prev1=nums[0],prev2=0,curr=prev1;
        for(int i=1;i<nums.length;i++){
            curr=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
    
}