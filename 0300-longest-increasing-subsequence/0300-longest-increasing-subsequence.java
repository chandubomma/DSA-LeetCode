class Solution {
    public int lengthOfLIS(int[] nums) {
      HashMap<Integer,Integer> map = new HashMap<>();
        return lts(nums,nums.length-1,map);
    }
    
    public int lts(int[] nums,int n,HashMap<Integer,Integer> map){
        if(n==0)return 1;
        int notTaken = lts(nums,n-1,map);
        int taken=1;
        for(int i=n-1;i>=0;i--){
            if(nums[n]>nums[i]){
                if(map.get(nums[i])!=null)taken=Math.max(taken,1+map.get(nums[i]));
                else taken=Math.max(taken,1+lts(nums,i,map));
            }
        }
        map.put(nums[n],taken);
        return Math.max(taken,notTaken);
    }
  
}