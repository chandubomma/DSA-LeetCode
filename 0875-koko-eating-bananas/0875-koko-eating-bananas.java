class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long high=(long)piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>high)high=piles[i];
        }
      
        long low=1,mid,hrs,ans=high;
        while(low<=high){
            mid=(int)(low+high)/2;
            hrs=calculateHrs(piles,mid);
            if(hrs>h)low=mid+1;
            else {
                high=mid-1;
                ans=mid;
            }
        }
        return (int)ans;
    }
    public long calculateHrs(int[] piles,long k){
        long hrs=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]%k==0)hrs+=piles[i]/k;
            else hrs+=piles[i]/k+1;
        }
        return hrs;
    }
}