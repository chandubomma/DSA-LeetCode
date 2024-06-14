class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] bad = new int[nums.length];
        Arrays.fill(bad,0);
        for(int i=1;i<bad.length;i++)if(nums[i]%2==nums[i-1]%2)bad[i]=1;
        for(int i=1;i<bad.length;i++)bad[i]+=bad[i-1];
        int i=0;
        for(int[] q:queries){
            if(bad[q[0]]==bad[q[1]])ans[i++]=true;
            else ans[i++]=false;
        }
        return ans;
    }
}