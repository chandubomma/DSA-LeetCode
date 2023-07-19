class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : days)set.add(i);
        int[] dp = new int[366];
        Arrays.fill(dp,-1);
        return mct(costs,set,days[0],days[days.length-1],dp);
    }
    
    public int mct(int[] costs,HashSet<Integer> set,int n,int lastDay,int[] dp){
        if(n>lastDay)return 0;
        if(dp[n]!=-1)return dp[n];
        if(!set.contains(n))return mct(costs,set,n+1,lastDay,dp);
        int oneDay = costs[0]+mct(costs,set,n+1,lastDay,dp);
        int sevenDays = costs[1]+mct(costs,set,n+7,lastDay,dp);
        int thirtyDays = costs[2]+mct(costs,set,n+30,lastDay,dp);
        return dp[n]=Math.min(oneDay,Math.min(sevenDays,thirtyDays));
    }
}