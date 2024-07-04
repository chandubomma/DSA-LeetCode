class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<TreeSet<Integer>> ans = new ArrayList<>();
        List<List<Integer>> fans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            ans.add(new TreeSet<>());
        }
        for(int[] ed :edges){
            adj.get(ed[0]).add(ed[1]);
            indegree[ed[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)if(indegree[i]==0)q.add(i);
        int node;
        while(!q.isEmpty()){
            node = q.poll();
            for(int i : adj.get(node)){
               indegree[i]--;
                ans.get(i).addAll(ans.get(node));
                ans.get(i).add(node);
                if(indegree[i]==0)q.add(i);
            }
        }
        for(int i=0;i<n;i++)fans.add(new ArrayList(ans.get(i)));
        return fans;
    }
   
}