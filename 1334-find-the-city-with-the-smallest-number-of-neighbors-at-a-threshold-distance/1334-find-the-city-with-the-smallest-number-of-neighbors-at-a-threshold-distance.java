class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p1.getValue(),p2.getValue()));
        ArrayList<ArrayList<Pair<Integer,Integer>>> adj = new ArrayList<>();
        int[] d = new int[n];
        for(int i=0;i<n;i++){ 
            adj.add(new ArrayList<>());
        }
        for(int[] ed: edges){
            adj.get(ed[0]).add(new Pair(ed[1],ed[2]));
            adj.get(ed[1]).add(new Pair(ed[0],ed[2]));
        }
        int[] counter = new int[n];
        for(int i=0;i<n;i++){
            pq.clear();
            Arrays.fill(d,Integer.MAX_VALUE);
            pq.add(new Pair(i,0));
            d[i]=0;Pair p1;
            while(!pq.isEmpty()){
                p1 = pq.poll();
                for(Pair p2:adj.get((int)p1.getKey())){
                    if((int)p1.getValue()+(int)p2.getValue()<d[(int)p2.getKey()]){
                        d[(int)p2.getKey()] = (int)p1.getValue()+(int)p2.getValue();
                        pq.add(new Pair((int)p2.getKey(),d[(int)p2.getKey()]));
                    }
                }
            }
            for(int j=0;j<n;j++){
                if(j!=i && d[j]<=distanceThreshold)counter[i]++;;
            }
        }
        int ans=0;
        
        for(int i=1;i<n;i++){
            if(counter[i]<=counter[ans])ans=i;
        }
        return ans;
    }
}