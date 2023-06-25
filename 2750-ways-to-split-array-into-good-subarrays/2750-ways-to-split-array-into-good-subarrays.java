class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
       int prev=-1,curr=0;long ans=0L,m=1000000007L;
        while(curr<nums.length){
            if(nums[curr]==1){
                if(prev>=0)ans=ans*(curr-prev);
                else ans+=1;
                prev=curr;
                ans=ans%m;
            }
            curr++;
        }
        return (int)ans;
    }  
}