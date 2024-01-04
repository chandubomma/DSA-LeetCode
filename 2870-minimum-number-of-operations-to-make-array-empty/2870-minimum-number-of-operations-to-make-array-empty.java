class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count=0;
        for(int i:map.keySet()){
            int freq = map.get(i);
            while(freq>0){
                if(freq%3==0){
                    freq-=3;count++;
                }
                else if(freq%2==0){
                    freq-=2;
                    count++;
                }else {
                   freq-=3;count++; 
                }
            }
            map.put(i,freq);
        }
        for(int i:map.keySet())if(map.get(i)!=0)return -1;
        return count;
    }
}