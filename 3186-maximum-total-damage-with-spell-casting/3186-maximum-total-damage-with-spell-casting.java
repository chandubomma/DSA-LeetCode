class Solution {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer,Long> dp = new HashMap<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i : power)freq.put(i,freq.getOrDefault(i,0)+1);
        Arrays.sort(power);
        return solve(power,power[power.length-1],dp,freq);
    }
    
    public long solve(int[] power,int n,HashMap<Integer,Long> dp,HashMap<Integer,Integer> freq){
        if(n<1)return 0;
        if(dp.containsKey(n))return dp.get(n);
        long taken  = (long)n*freq.getOrDefault(n,0);
        if(n-3>0){
            int next = flb(power,n-3);
            if(next>=0){
               taken+=solve(power,power[next],dp,freq);
            }
        }
        long notTaken = 0;
        if(n-1>0){
            int next = flb(power,n-1);
            if(next>=0){
                notTaken = solve(power,power[next],dp,freq);
            }
        }
        dp.put(n,Math.max(taken,notTaken));
        return Math.max(taken,notTaken);
    }
    
    public int flb(int[] power,int n){
       int l = 0, r = power.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (power[mid] <= n) l = mid;
            else r = mid - 1;
        }
        return power[l] <= n ? l: -1;
    }
}