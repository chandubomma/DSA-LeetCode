class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1,high=0,mid,ans;
        for(int i : nums)if(i>high)high=i;
        ans=high;
        while(low<=high){
            mid=(low+high)/2;
            if(check(nums,maxOperations,mid)){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }
    
    public boolean check(int[] nums,int maxOperations,int penality){
        int count=0;
        for(int i : nums){
            if(i%penality==0)count+=i/penality-1;
            else  count+=i/penality;
        }
        return count<=maxOperations;
    }
}