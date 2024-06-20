class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0,mid,ans;
        for(int i : weights){
            high+=i;
            low = Math.max(low,i);
        }
        ans=high;
        while(low<=high){
            mid=(low+high)/2;
            if(canShip(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    
    public boolean canShip(int[] wts,int days,int capacity){
        int sum=0,d=0;
        for(int w : wts){
            sum+=w;
            if(sum==capacity){
                d++;
                sum=0;
            }
            else if(sum>capacity){
                d++;
                sum=w;
            }
        }
        if(sum>0)d++;
        return d<=days;
    }
}