class Solution {
    public int maximumBeauty(int[] nums, int k) {
       int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,freq=0;
        for(int i:nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        int[] pre = new int[max+1];
        for(int i:nums)pre[i]++;
        freq=pre[0];
        for(int i=1;i<pre.length;i++){
            freq = Math.max(freq,pre[i]);
            pre[i]+=pre[i-1];
        }
        if(k==0)return freq;
        int ans=0,count;
        for(int i=min;i<=max;i++){
            count = pre[i+k<=max?i+k:max]-((i-k>0)?pre[i-k-1]:0);
            ans = Math.max(ans,count);
        }
        return ans;
    }
}