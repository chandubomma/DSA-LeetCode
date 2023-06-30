class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int sum=0;
        Arrays.sort(candidates);
        cs(list,list2,candidates,0,target);
        return (list);
    }
    
     public void cs(ArrayList<List<Integer>> list,List<Integer> list2,int[] nums,int n,int target){
        if(target<0)return;
        if(target==0){
            list.add(new ArrayList<>(list2));
            return;
        }
        if(n>=nums.length)return;
         for(int i=n;i<nums.length;i++){
             if(i>n && nums[i]==nums[i-1])continue;
                list2.add(nums[i]);
                cs(list,list2,nums,i+1,target-nums[i]);
                list2.remove(list2.size()-1);
         }
        return;
    }
}