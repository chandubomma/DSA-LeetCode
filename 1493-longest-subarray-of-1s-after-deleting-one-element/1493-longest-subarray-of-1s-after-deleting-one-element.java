class Solution {
    public int longestSubarray(int[] nums) {
        int maxlen=0;int flag=-1;
        int l=0,j=0;
        while(j<nums.length){
            if(nums[l]!=1){
                l++;j=l;continue;
            }
            if(nums[j]==1){
                j++;
            }else{
                if(j<nums.length-1 && nums[j+1]==1 && flag==-1){
                    j++;flag=j;
                }
                else{
                    if(flag!=-1){
                        maxlen = Math.max(maxlen,j-l-1);
                        l=j=flag;flag=-1;
                    }
                    else {
                        maxlen = Math.max(maxlen,j-l);
                        l=j;
                    } 
                   
                }
            }
        }
        if(flag!=-1)maxlen = Math.max(maxlen,j-l-1);
        else  maxlen = Math.max(maxlen,j-l);
        flag=-1;
        for(int i=0;i<nums.length;i++)if(nums[i]==0)flag=1;
        if(flag==-1)maxlen--;
        return maxlen;
    }
}