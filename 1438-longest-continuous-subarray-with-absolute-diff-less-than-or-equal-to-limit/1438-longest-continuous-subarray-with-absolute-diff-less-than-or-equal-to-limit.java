class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int i=0,j=0,min=nums[0],max=nums[0],ans=1;
        while(j<nums.length){
            pq1.add(nums[j]);
            pq2.add(nums[j]);
            min = pq1.peek();
            max = pq2.peek();
            while((Math.abs(nums[j]-min)>limit || Math.abs(max-nums[j])>limit) && i<j ){
                ans = Math.max(ans,j-i);
                pq1.remove(nums[i]);
                pq2.remove(nums[i]);
                min = pq1.peek();
                max = pq2.peek();
                i++;
            }
            j++;
        }
        ans = Math.max(ans,j-i);
        return ans;
    }
}