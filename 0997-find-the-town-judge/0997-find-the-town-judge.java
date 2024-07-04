class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n+1];
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int[] t : trust){
            adj.get(t[0]).add(t[1]);
            indegree[t[1]]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1)list.add(i);
        }
        int count=0,ans=-1;
        for(int i : list){
            if(adj.get(i).size()==0){
                ans=i;
                count++;
            }
        }
        if(count>1)return -1;
        return ans;
        
    }
}