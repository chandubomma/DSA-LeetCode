class Solution {
    public int maximumBeauty(int[] nums, int k) {
       Arrays.sort(nums);
        int i=0,j=0,max=0;
        while(j<nums.length){
            if(nums[j]-nums[i]<=2*k)j++;
            else{
                max=Math.max(max,j-i);
                i++;
            }
        }
         max=Math.max(max,j-i);
        return max;
    }
}