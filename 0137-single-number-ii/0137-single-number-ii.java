class Solution {
    public int singleNumber(int[] nums) {
       int s,l,ans=0;
        for(int i=0;i<32;i++){
            s=0;
            for(int num:nums){
                l=(num>>i)&1;
                s+=l;
            }
            s=s%3;
            ans=ans|(s<<i);
        }
        return ans;
    }
}