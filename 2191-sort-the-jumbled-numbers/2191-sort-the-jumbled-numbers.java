class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer i:nums){
            map.put(i,convertToMap(i,mapping));
        }
        Integer[] arr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)arr[i] = nums[i];
        Arrays.sort(arr,(a,b)->Integer.compare(map.get(a),map.get(b)));
        for(int i=0;i<nums.length;i++)nums[i]=arr[i];
        return nums;
    }
    
    public Integer convertToMap(Integer temp,int[] mapping){
        Integer i=1,n=0;
        if(temp==0)return mapping[0];
        while(temp>0){
            n += mapping[(temp%10)]*i;
            temp = temp/10;
            i=i*10;
        }
        return n;
    }
}