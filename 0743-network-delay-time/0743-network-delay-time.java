class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int[] time : times){
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p1.wt,p2.wt));
        int[] time = new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k]=0;
        pq.offer(new Pair(k,0));
        Pair p;
        while(!pq.isEmpty()){
            p = pq.poll();
            for(Pair p2 : adj.get(p.tgt)){
                if(p.wt+p2.wt<time[p2.tgt]){
                    time[p2.tgt] = time[p.tgt]+p2.wt;
                    pq.offer(new Pair(p2.tgt,time[p2.tgt]));
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(time[i]==Integer.MAX_VALUE)return -1;
            ans = Math.max(ans,time[i]);
        }
        return ans;
    }
    
    class Pair{
        int tgt;
        int wt;
        public Pair(int tgt,int wt){
            this.tgt = tgt;
            this.wt = wt;
        }
    }
}