class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        HashMap<String,Integer> map = new HashMap<>();
        int ans=cc(coins,amount,coins.length-1,map);
        if(ans>=100000)return -1;
        else return ans;
    }
    
    public int cc(int[] coins,int amount,int n,HashMap<String,Integer> map){
        if(amount==0)return 0;
        if(n==0){
            if(amount%coins[0]==0)return amount/coins[0];
            else return 100000;
        }
        String key = Integer.toString(n)+Integer.toString(amount);
        if(map.get(key)!=null)return map.get(key);
        if(amount%coins[n]==0){
            map.put(key,amount/coins[n]);
            return map.get(key);
        }
        int notTaken = cc(coins,amount,n-1,map);
        if(coins[n]<=amount){
            int taken=100000;
            taken=1+cc(coins,amount-coins[n],n,map);
            map.put(key,Math.min(taken,notTaken));
            return Math.min(notTaken,taken);
        }
        map.put(key,notTaken);
       return notTaken;
    }
}