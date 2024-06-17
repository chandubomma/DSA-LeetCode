class Solution {
    public boolean judgeSquareSum(int c) {
        HashMap<Long,Integer> map = new HashMap<>();
        for(long i=0;i*i<=c;i++){
            map.put(i*i,(int)i);
        }
        for(long i : map.keySet()){
            if(map.getOrDefault(c-i,-1)!=-1)return true;
        }
        return false;
    }
}

