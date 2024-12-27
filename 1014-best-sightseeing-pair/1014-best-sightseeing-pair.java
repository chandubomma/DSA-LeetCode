class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] pre = new int[values.length];
        for(int i=0;i<values.length;i++){
            pre[i] = values[i]-i;
        }
        for(int i=values.length-2;i>=0;i--){
            pre[i] = Math.max(pre[i],pre[i+1]);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<values.length-1;i++){
            ans = Math.max(ans,values[i]+i+pre[i+1]);
        }
        return ans;
    }
}