class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low =0,high=nums[nums.length-1]-nums[0],mid,ans=0,count;
        while(low<=high){
            mid=(low+high)/2;
            count=countValidPairs(nums,mid);
            if(count>=p){
                ans=mid;
                high=mid-1;
            }
            else if(count<p)low=mid+1;
        }
        return ans;
    }
    
    public int countValidPairs(int[] nums,int diff){
        int count=0,i=0;
        while(i<nums.length-1){
            if(nums[i+1]-nums[i]<=diff){
                count++;
                i++;
            }
            i++;
        }
        return count;
    }
}