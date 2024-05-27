class Solution {
    public int specialArray(int[] nums) {
        int n=nums.length;
        int[] arr = new int[1001];
        for(int i : nums)arr[i]++;
        for(int i=1;i<=1000;i++)arr[i]+=arr[i-1];
        for(int i=1;i<=1000;i++){
            if(i==n-arr[i-1])return i;
        }
        return -1;
    }
        
}