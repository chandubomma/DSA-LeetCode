class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Triple>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] flight: flights){
            adj.get(flight[0]).add(new Triple(flight[1],flight[2],0));
        }
        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        Queue<Triple> pq = new LinkedList<>();
        pq.offer(new Triple(src,0,-1));
        price[src]=0;Triple t;
        while(!pq.isEmpty()){
            t = pq.poll();
            for(Triple t2 : adj.get(t.node)){
                if(t.wt+t2.wt<price[t2.node] && t.stp<k){
                    price[t2.node] = t.wt+t2.wt;
                    pq.offer(new Triple(t2.node,price[t2.node],t.stp+1));
                }
            }
        }
        if(price[dst]==Integer.MAX_VALUE)return -1;
        return price[dst];
    }
    
    class Triple{
        int node;
        int wt;
        int stp;
        public Triple(int node,int wt,int stp){
            this.node = node;
            this.wt = wt;
            this.stp = stp;
        }
    }
}