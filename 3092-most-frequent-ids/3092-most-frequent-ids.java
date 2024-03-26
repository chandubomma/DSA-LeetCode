class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        HashMap<Integer,Pair> map1 = new HashMap<>();
        TreeMap<Pair,Long>  map = new TreeMap<>((p1, p2) -> {
            int compareFreq = Long.compare(p1.frq, p2.frq); 
            if (compareFreq != 0) {
                return compareFreq; 
            }
            return Integer.compare(p1.num, p2.num);
        });
        long[] ans = new long[nums.length];
        for(int i=0;i<nums.length;i++){
           if(map1.get(nums[i])==null){
               map1.put(nums[i],new Pair(nums[i],(long)freq[i]));
               map.put(map1.get(nums[i]),(long)freq[i]);
           }else{
               Pair p = map1.get(nums[i]);
               map.remove(p);
               p.frq+=freq[i];
               map.put(p,p.frq);
           }
            ans[i] = map.get(map.lastKey());
        }
       return ans;
    }
    
    class Pair{
        int num;
        long frq;
        public Pair(int num,long frq){
            this.num=num;
            this.frq=frq;
        }
    }
   
}