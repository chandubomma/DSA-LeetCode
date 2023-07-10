class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0,h=nums.length-1,mid;
        if(nums.length==1)return nums[0];
        while(l<=h){
            mid=(int)((long)l+h)/2;
            if((mid>0 && nums[mid]!=nums[mid-1]) && (mid<nums.length-1 && nums[mid]!=nums[mid+1]))return nums[mid];
            else if(mid==0 && nums[mid]!=nums[mid+1])return nums[mid];
            else if(mid==nums.length-1 && nums[mid]!=nums[mid-1])return nums[mid];
            else if((mid%2==0 &&mid<nums.length-1 && nums[mid]==nums[mid+1]) || (mid%2==1 && mid>0 && nums[mid]==nums[mid-1]))l=mid+1;
            else  h=mid-1;
        }
        return -1;
    }
}