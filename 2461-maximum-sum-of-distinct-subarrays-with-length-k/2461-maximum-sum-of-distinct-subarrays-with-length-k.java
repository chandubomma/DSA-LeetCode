class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0L,ans=0L;
        HashMap<Integer,Integer> freq = new HashMap<>();
        int i=0,j=0;
        while(j<nums.length){
            if(freq.getOrDefault(nums[j],0)>0){
                while(freq.get(nums[j])>0){
                    freq.put(nums[i],freq.get(nums[i])-1);
                    sum-=nums[i];
                    i++;
                }
            }
            freq.put(nums[j],1);
            sum+=nums[j];
            j++;
            if(j-i==k){
                ans=Math.max(ans,sum);
                freq.put(nums[i],freq.get(nums[i])-1);
                sum-=nums[i];
                i++;
            }
        }
        return ans;
    }
}