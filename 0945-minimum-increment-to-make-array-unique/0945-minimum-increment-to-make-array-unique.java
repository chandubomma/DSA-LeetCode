class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Boolean> map = new HashMap<>();
        int ans=0,prev=nums[0];
         map.put(nums[0],true);
        for(int i=1;i<nums.length;i++){
            if(map.getOrDefault(nums[i],false)){
                if(nums[i]<prev){
                    ans=ans+prev+1-nums[i];
                    nums[i]=prev+1;
                }
                else{
                     nums[i]+=1;ans++;
                }
            }
            if(nums[i]>prev)prev=nums[i];
            map.put(nums[i],true);
        }
        return ans;
    }
}