class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length,m=Integer.MIN_VALUE,sum=0,psum=0;
        for(int i : nums)sum+=i;
        for(int i=0;i<n;i++){
            psum+=i*nums[i];
        }
        m=psum;
        int i=n-1;
        while(i>=0){
            psum=psum+sum-n*nums[i];
            m=Math.max(m,psum);
            i--;
        }
        return m;
    }
}