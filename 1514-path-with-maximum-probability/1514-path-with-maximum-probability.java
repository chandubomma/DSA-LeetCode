class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        double[] prob = new double[n];
        Arrays.fill(prob,Integer.MIN_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->Double.compare(p2.p,p1.p));
        prob[start_node]=1;Pair p1;
        pq.offer(new Pair(start_node,1));
        while(!pq.isEmpty()){
            p1 = pq.poll();
            for(Pair p2 : adj.get(p1.node)){
                if(p1.p*p2.p>prob[p2.node]){
                    prob[p2.node] = p1.p*p2.p;
                    pq.offer(new Pair(p2.node,prob[p2.node]));
                }
            }
        }
        if(prob[end_node]==Integer.MIN_VALUE)return 0;
        return prob[end_node];
    }
    
    class Pair{
        int node;
        double p;
        public Pair(int node,double p){
            this.node = node;
            this.p = p;
        }
    }
}