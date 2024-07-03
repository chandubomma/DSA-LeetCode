class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4)return 0;
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[n-1]-nums[0];
        int i=n-4;
        while(i<n){
            ans = Math.min(ans,Math.abs(nums[i]-nums[(i+4)%n]));
            i++;
        }
        return ans;
    }
}