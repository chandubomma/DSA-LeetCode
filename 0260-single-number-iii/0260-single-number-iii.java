class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i : nums)xor^=i;
        int mask = 1;
        while((xor & mask) == 0){
            mask=mask<<1;
        }
        int[] arr = new int[2];
        for(int i : nums){
            if((i & mask)==0)arr[0]^=i;
            else arr[1]^=i;
        }
        return arr;
    }
}