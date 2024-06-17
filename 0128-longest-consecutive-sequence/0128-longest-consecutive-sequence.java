class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> dp = new HashMap<>();
        HashMap<Integer,Boolean> has = new HashMap<>();
        for(int i : nums)has.put(i,true);
        int ans=0;
        for(int i : nums)ans =  Math.max(ans,solve(i,dp,has));
        return ans;
    }
    public int solve(int n,HashMap<Integer,Integer> dp,HashMap<Integer,Boolean> has){
        if(!has.containsKey(n))return 0;
        if(dp.containsKey(n))return dp.get(n);
        int len = 1+solve(n-1,dp,has);
        dp.put(n,len);
        return len;
    }
}