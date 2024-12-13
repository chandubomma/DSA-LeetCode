class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] isBanned = new boolean[n+1];
        for(int i:banned){
            if(i<=n)isBanned[i]=true;
        }
        int sum=0,count=0;
        for(int i=1;i<=n;i++){
            if(!isBanned[i]){
                sum+=i;
                if(sum<=maxSum)count++;
                else break;
            }
        }
        return count;
    }
}