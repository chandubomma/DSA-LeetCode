class Solution {
    public long sumDigitDifferences(int[] nums) {
        long ans=0;
        String[] strs = Arrays.stream(nums).mapToObj(Integer::toString).toArray(String[]::new);
        int len =strs[0].length(),n=strs.length;char c;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.clear();
            for(int j=0;j<n;j++){
                c=strs[j].charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            for(int j=0;j<n;j++){
                c=strs[j].charAt(i);
                ans+=n-j-map.getOrDefault(c,0);
                map.put(c,map.getOrDefault(c,0)-1);
                if(map.getOrDefault(c,0)<1)map.remove(c);
            }
        }
       return ans;
    }
}