class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int i=0,j=0,ans=0;
        long prod = 1;
        while(i<nums.length && i<=j && j<nums.length){
            prod*=nums[j];
            while(prod>=k){
                prod/=nums[i];
                i++;
            }
                ans+=j-i+1;
                j++;
        }
        return ans;
    }
}