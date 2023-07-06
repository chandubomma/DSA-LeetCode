class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,min=nums.length,sum=0;
        for(int p=0;p<nums.length;p++){
            sum=sum+nums[p];
        }
        if(sum<target)return 0;
        if(sum==target)return nums.length;
        sum=nums[0];
        while(j<nums.length && i<=j){
            if(sum>=target){
                if(j-i+1<min)min=j-i+1;
                sum=sum-nums[i];
                i++;
            }else{
                j++;
                if(j<nums.length)
                sum=sum+nums[j];
               
            }
        }
        return min;
    }
}