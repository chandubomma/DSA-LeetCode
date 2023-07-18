class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0,j=nums.length-1,count=j+1,temp;
       
        while(i<=j){
            if(nums[i]!=val){i++;continue;}
            if(nums[j]==val){count--;j--;continue;}
            temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;j--;count--;
        }
        return count;
    }
}