class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        HashMap<String,Boolean> map = new HashMap<>();
        StringBuilder str = new StringBuilder("");
        Arrays.sort(nums);
        sub(list,list2,nums,0,str,map);
        return list;
        
    }
    public void sub(List<List<Integer>> list,List<Integer> list2,int[] nums,int n,StringBuilder str,HashMap<String,Boolean> map){
        if(n>=nums.length){
            str= new StringBuilder("");
            for(int i:list2)str.append(i);
            if(map.get(str.toString())==null){
                 list.add(new ArrayList<>(list2));
                map.put(str.toString(),true);
            }
            return;
        }
        list2.add(nums[n]);
        sub(list,list2,nums,n+1,str,map);
        list2.remove(list2.size()-1);
        sub(list,list2,nums,n+1,str,map);
        return;
    }
}