class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize==1)return true;
        if(hand.length%groupSize!=0)return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i : hand)map.put(i,map.getOrDefault(i,0)+1);
        int key;
        while(map.size()>0){
            key = map.firstKey();
            for(int i=1;i<groupSize;i++){
                if(map.getOrDefault(key+i,0)==0)return false;
            }
            for(int i=0;i<groupSize;i++){
                map.put(key+i,map.get(key+i)-1);
                if(map.get(key+i)<1)map.remove(key+i);
            }
        }
        return true;
    }
}