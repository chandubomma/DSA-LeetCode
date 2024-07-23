class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Integer[] sortNums = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)sortNums[i] = nums[i];
        Arrays.sort(sortNums,(a,b)->{
            if(Integer.compare(map.get(a),map.get(b))!=0)
                return Integer.compare(map.get(a),map.get(b));
            else return Integer.compare(b,a);
        });
        for(int i=0;i<nums.length;i++)nums[i] = sortNums[i];
            return nums;
    }
}