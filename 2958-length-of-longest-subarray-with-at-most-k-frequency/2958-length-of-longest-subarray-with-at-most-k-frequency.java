class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i=0,j=0,maxl=0,freq;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j<nums.length){
            freq = map.getOrDefault(nums[j],0);
            if(freq==k){
                maxl = Math.max(maxl,j-i);
                while(nums[i]!=nums[j]){
                    map.put(nums[i],map.get(nums[i])-1);
                    i++;
                }
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }else{
                map.put(nums[j],freq+1);
                j++;
            }
        }
        maxl = Math.max(maxl,j-i);
        return maxl;
    }
}