class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]&1;
        }
        int i=0,j=0,count=0,ans=0,prev=0;
        while(j<nums.length){
            count+=nums[j];
            if(count==k){
                prev=0;
                while(count==k){
                    prev++;
                    count-=nums[i];
                    i++;
                }
            }
            ans+=prev;
            j++;
        }
        return ans;
    }
}