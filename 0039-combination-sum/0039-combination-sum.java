class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        cs(list,list2,candidates,0,target);
        return list;
    }
    
    public void cs(List<List<Integer>> list,List<Integer> list2,int[] nums,int n,int target){
        if(target<0)return;
        if(n>=nums.length)return;
        if(target==0){
            list.add(new ArrayList<>(list2));
            return;
        }
        
        list2.add(nums[n]);
        cs(list,list2,nums,n,target-nums[n]);
        list2.remove(list2.size()-1);
        cs(list,list2,nums,n+1,target);
        return;
        
    }
}