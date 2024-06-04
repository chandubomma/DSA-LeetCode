class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Long ans=0L;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums2){
            map.put(i*k,map.getOrDefault(i*k,0)+1);
        }
        for(int n:nums1){
            if(n%k!=0)continue;
            for(int i=1;i*i<=n;i++){
                if(n%i!=0)continue;
                ans+=map.getOrDefault(i,0);
                if(i!=n/i)ans+=map.getOrDefault(n/i,0);
            }
        }
        return ans;
    }
}