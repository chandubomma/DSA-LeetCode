class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ed: edges){
            adj.get(ed[0]).add(new Pair(ed[1],ed[2]));
            adj.get(ed[1]).add(new Pair(ed[0],ed[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p1.wt,p2.wt));
        int[] d = new int[n];
        int[] count = new int[n];
        for(int i=0;i<n;i++){
            pq.clear();
            Arrays.fill(d,Integer.MAX_VALUE);
            pq.offer(new Pair(i,0));
            d[i]=0;Pair p1;
            while(!pq.isEmpty()){
                p1 = pq.poll();
                for(Pair p2:adj.get(p1.city)){
                    if(p1.wt+p2.wt<d[p2.city]){
                        d[p2.city] = p1.wt+p2.wt;
                        pq.offer(new Pair(p2.city,d[p2.city]));
                    }
                }
            }
            for(int j=0;j<n;j++){
                if(j!=i && d[j]<=distanceThreshold)count[i]++;
            }
        }
        int ans=0;
        for(int i=1;i<n;i++){
            if(count[i]<=count[ans])ans=i;
        }
        return ans;
    }
    
    class Pair{
        int city;
        int wt;
        public Pair(int city,int wt){
            this.city = city;
            this.wt = wt;
        }
    }
}