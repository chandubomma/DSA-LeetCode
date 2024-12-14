class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans=0;
        int i=0,j=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b)->Integer.compare(a,b));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        while(j<nums.length && i<=j){
            minHeap.offer(nums[j]);
            maxHeap.offer(nums[j]);
            while(Math.abs(minHeap.peek()-maxHeap.peek())>2){
                minHeap.remove(nums[i]);
                maxHeap.remove(nums[i]);
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        
        return ans;
    }
}