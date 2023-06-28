class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        HashMap<Integer,Boolean> map =new HashMap<>();
        HashMap<String,Boolean> map2 =new HashMap<>();
        permutation(list,list2,map,map2,nums);
        return list;
    }
    
     public void permutation(List<List<Integer>> list,List<Integer> list2,HashMap<Integer,Boolean> map,HashMap<String,Boolean> map2,int[] nums){
        if(list2.size()>=nums.length){
            StringBuilder str = new StringBuilder();
            for(int i:list2)str.append(i);
            if(map2.get(str.toString())==null){
                 list.add(new ArrayList<>(list2));
                map2.put(str.toString(),true);
            }
           
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(i)==null || map.get(i)==false){
                map.put(i,true);
                list2.add(nums[i]);
                permutation(list,list2,map,map2,nums);
                list2.remove(list2.size()-1);
                map.put(i,false);
            }
        }
        return;
        
    }
}