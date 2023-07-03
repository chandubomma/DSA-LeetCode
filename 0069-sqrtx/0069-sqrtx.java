class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1)return x;
        long l=1,h=x,mid,ans=0;
        while(l<=h){
            mid=(l+h)/2;
            if(mid*mid==(long)x){
                ans=mid;
                break;
            }
            else if(mid*mid<(long)x){
                ans=mid;
                l=mid+1;
            }else h=mid-1;
        }
        return (int)ans;
    }
}