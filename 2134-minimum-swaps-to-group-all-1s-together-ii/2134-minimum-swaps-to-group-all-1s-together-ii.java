class Solution {
    public int minSwaps(int[] nums) {
        int count=0,ans=0,fans;
        for(int i: nums)if(i==0)count++;
        int i=0,j=0;
        while(j<count){
          if(nums[j]!=0)ans++;
            j++;
        }
        fans=ans;
        for( i=1;i<nums.length;i++){
            if(nums[(i+count-1)%nums.length]==1)ans++;
            if(nums[i-1]==1)ans--;
            fans = Math.min(fans,ans);
        }
        return fans;
    }
}