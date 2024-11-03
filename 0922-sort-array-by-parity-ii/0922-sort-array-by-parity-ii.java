class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i=0,j=1;
        while(i<nums.length-1 && j<nums.length){
            if(j<=i)j=i+1;
            if(i%2 != nums[i]%2){
                if(nums[j]%2 == i%2){
                    swap(nums,i,j);
                    i++;j++;
                }else j++;
            }else i++;
        }
        return nums;
    }
    
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}