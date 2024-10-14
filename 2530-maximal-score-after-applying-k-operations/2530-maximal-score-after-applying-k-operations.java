class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i:nums)pq.offer(i);
        long score=0;
        int top;
        while(k-->0){
            top = pq.poll();
            score+=top;
            pq.offer((int)Math.ceil(top/3.0));
        }
        return score;
    }
}