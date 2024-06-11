class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i : arr1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] ans = new int[arr1.length];
        int i=0;
        for(int num : arr2){
            for(int j=0;j<map.get(num);j++)ans[i++]=num;
            map.remove(num);
        }
        for(int num : map.keySet()){
            for(int j=0;j<map.get(num);j++)ans[i++]=num;
        }
        return ans;
    }
}