class Solution {
    public void sortColors(int[] nums) {
        int start=0,end=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && i>start){
                swap(nums,start,i);
                start++;i--;
            }else if(nums[i]==2 && i<end){
                swap(nums,i,end);
                end--;i--;
            }
        }
    }
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}