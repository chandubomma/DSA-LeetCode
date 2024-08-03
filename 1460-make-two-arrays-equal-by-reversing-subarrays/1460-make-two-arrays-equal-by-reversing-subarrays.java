class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : target)map.put(i,map.getOrDefault(i,0)+1);
        for(int i : arr){
            if(map.get(i)==null)return false;
            map.put(i,map.get(i)-1);
        }
        for(int i:map.values())if(i!=0)return false;
        return true;
    }
}