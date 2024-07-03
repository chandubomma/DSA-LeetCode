class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        int n = quiet.length;
        for(int i=0;i<n;i++){
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }
        for(int i=0;i<richer.length;i++){
            adj1.get(richer[i][0]).add(richer[i][1]);
            adj2.get(richer[i][1]).add(richer[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            indegree[i]=adj2.get(i).size();
            if(indegree[i]==0)q.add(i);
        }
        int node,temp;
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        while(!q.isEmpty()){
            node=q.poll();
            temp=node;
            for(int i : adj2.get(node)){
                if(quiet[ans[i]]<quiet[temp])temp=ans[i];
            }
            ans[node]=temp;
            for(int i : adj1.get(node)){
                indegree[i]--;
                if(indegree[i]==0)q.add(i);
            }
        }
        return ans;
    }
}