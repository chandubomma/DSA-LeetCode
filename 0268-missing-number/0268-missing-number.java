class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            if(!binarySearch(nums,i))return i;
        }
        return -1;
    }
    public boolean binarySearch(int[] nums,int target){
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target)return true;
            else if(target<nums[mid])high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}