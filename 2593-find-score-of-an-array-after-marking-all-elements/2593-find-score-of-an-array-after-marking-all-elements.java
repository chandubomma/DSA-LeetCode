class Solution {
    public long findScore(int[] nums) {
        boolean[] isMarked = new boolean[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
        (Integer.compare(nums[a],nums[b])==0?Integer.compare(a,b):Integer.compare(nums[a],nums[b])));
        for(int i=0;i<nums.length;i++)pq.offer(i);
        long score=0;int ind;
        while(pq.size()>0){
            ind=pq.poll();
            if(!isMarked[ind]){
                score+=nums[ind];
                isMarked[ind]=true;
                if(ind-1>=0)isMarked[ind-1]=true;
                if(ind+1<nums.length)isMarked[ind+1]=true;
            }
        }
        return score;
    }
}