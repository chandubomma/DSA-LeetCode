class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] map = new int[coins.length][amount+1];
        for(int[] row : map){
            Arrays.fill(row,-1);
        }
        int ans=cf(amount,coins,coins.length-1,map);
        return ans;
    }
    
    public int cf(int amount,int[] coins,int n,int[][] map){
        if(amount==0)return 1;
        if(n<0)return 0;
        if(map[n][amount]!=-1)return map[n][amount];
        int notTaken = cf(amount,coins,n-1,map);
        int taken =0;
        if(coins[n]<=amount)taken=cf(amount-coins[n],coins,n,map);
        map[n][amount]=taken+notTaken;
        return taken+notTaken;
    }
}