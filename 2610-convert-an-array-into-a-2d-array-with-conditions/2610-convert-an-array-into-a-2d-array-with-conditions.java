class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] map = new int[nums.length+1];
        Arrays.fill(map,0);
        ArrayList<List<Integer>> flist = new ArrayList<List<Integer>>();
        HashSet<Integer> set = new HashSet<>();
         for(int i:nums){
             map[i]++;
             set.add(i);
         }
        int count=0,temp;
        while(count<nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            Iterator<Integer> i = set.iterator();
            while(i.hasNext()){
                temp=i.next();
                if(map[temp]>0){
                    list.add(temp);
                    map[temp]--;
                    count++;
                }
            }
            flist.add(list);
        }
        return flist;
    }
}