class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);int upb,limit,ans=0;
        for(int i:ages){
            upb=upperBound(ages,i);
            limit=Limit(ages,(int)(0.5*i)+7);
            if(upb>=0 && limit>=0 && upb>limit)
            ans+=(upb-limit);
        }
        return ans;
    }
    
    public int upperBound(int[] ages,int target){
        int l=0,h=ages.length-1,mid=0,ans=-1;
        while(l<=h){
            mid=(int)((long)l+h)/2;
            if(ages[mid]==target){
                ans=mid;
                l=mid+1;
            }else if(target<ages[mid])h=mid-1;
            else l=mid+1;
        }
        return ans;
    }
     public int Limit(int[] ages,int target){
        int l=0,h=ages.length-1,mid=0,ans=-1;
        while(l<=h){
            mid=(int)((long)l+h)/2;
            if(ages[mid]>target){
                ans=mid;
                h=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
   
}