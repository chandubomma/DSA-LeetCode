class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
       int prev1=nums[0],prev2=0,curr1=prev1,curr2;
        for(int i=1;i<nums.length-1;i++){
            curr1=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=curr1;
        }
        
        prev1=nums[1];prev2=0;curr2=prev1;
         for(int i=2;i<nums.length;i++){
            curr2=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=curr2;
        }
        return Math.max(curr1,curr2);
    }
}