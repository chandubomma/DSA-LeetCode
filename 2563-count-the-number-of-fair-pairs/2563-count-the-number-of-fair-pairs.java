class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;int l,r;
        for(int i=0;i<nums.length;i++){
            l=upperBound(nums,lower-nums[i],i+1);
            r=upperBound(nums,upper-nums[i]+1,i+1);
            ans+=r-l;
        }
        return ans;
    }
    
    public int upperBound(int[] nums,int key,int l){
        int low=l, high=nums.length-1,mid,ans=l-1;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid]<key){
                ans=mid;
                low=mid+1;
            }else high=mid-1;
        }
        return ans;
    }
}