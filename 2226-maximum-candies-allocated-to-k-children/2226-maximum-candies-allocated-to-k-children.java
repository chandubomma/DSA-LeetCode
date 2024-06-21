class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low=1,high=10000000,mid,ans=0;
        while(low<=high){
            mid=(low+high)/2;
            if(check(candies,k,mid)){
                ans=mid;
                low=mid+1;
            }else high=mid-1;
        }
        return ans;
    }
    
    public boolean check(int[] candies,long k,int c){
        long count=0;
        for(int i : candies){
            count+=i/c;
        }
        return count>=k;
    }
}