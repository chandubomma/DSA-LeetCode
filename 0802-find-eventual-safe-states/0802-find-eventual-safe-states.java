class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(graph[i].length==0)q.add(i);
            for(int node : graph[i]){
                adj.get(node).add(i);
                indegree[i]++;
            }
        }
        int node;
        while(!q.isEmpty()){
            node = q.poll();
            list.add(node);
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0)q.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }
}