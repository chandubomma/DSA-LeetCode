class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)if(indeg[i]==0)q.add(i);
        int node;
        while(!q.isEmpty()){
            node = q.poll();
            list.add(node);
            for(int i : adj.get(node)){
                indeg[i]--;
                if(indeg[i]==0)q.add(i);
            }
        }
        if(list.size()!=numCourses)return new int[0];
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}