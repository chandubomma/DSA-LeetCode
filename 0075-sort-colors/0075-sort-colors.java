class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return;
    }
    
    public void quickSort(int[] arr,int low,int high){
       if(low>=high)return;
        int partitionIndex = partition(arr,low,high);
        quickSort(arr,low,partitionIndex-1);
        quickSort(arr,partitionIndex+1,high);
    }
    
    public int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i=low+1;
        int j=high;
        while(i<=j){
            while(i<=j && arr[i]<=pivot)i++;
            while(j>=i && arr[j]>pivot)j--;
            if(i>=j)break;
            swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
    
}