class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l,h,mid;int[] arr = new int[2];
        for(int i=0;i<numbers.length;i++){
            l=0;h=numbers.length-1;
            while(l<=h){
                mid=(l+h)/2;
                if(numbers[mid]==target-numbers[i] && mid!=i){
                    arr[0]=i+1;arr[1]=mid+1;
                    return arr;
                }else if(numbers[mid]>target-numbers[i])h=mid-1;
                else l=mid+1;
            }
        }
        return arr;
    }
}