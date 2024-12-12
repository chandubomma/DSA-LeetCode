class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i:gifts)pq.add(i);
        int pile;
        while(k-->0){
            pile = pq.poll();
            pq.add((int)Math.sqrt(pile));
        }
        long ans=0;
        while(pq.size()>0)ans+=pq.poll();
        return ans;
    }
}