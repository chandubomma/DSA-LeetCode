class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int minInd;
        while(k-->0){
            minInd=0;
            for(int i=1;i<nums.length;i++){
                if(nums[i]<nums[minInd])minInd=i;
            }
            nums[minInd]*=multiplier;
        }
        return nums;
    }
}