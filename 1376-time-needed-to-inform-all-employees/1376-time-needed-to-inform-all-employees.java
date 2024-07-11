class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,ArrayList<Integer>> sub = new HashMap<>();
        for(int i=0;i<n;i++){
            if(sub.get(manager[i])==null)sub.put(manager[i],new ArrayList<>());
            sub.get(manager[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[] out = new int[n];
        int[] time = new int[n];
        for(int i=0;i<n;i++){
            if(informTime[i]==0)q.offer(i);
            if(manager[i]!=-1)out[manager[i]]++;
        }
        int id,temp;
        while(q.size()>0){
                id = q.poll();
                temp=0;
                if(sub.get(id)!=null){
                    for(int i : sub.get(id)){
                        temp = Math.max(temp,time[i]);
                    }
                }
                time[id]=informTime[id]+temp;
                if(manager[id]!=-1 && !vis[manager[id]]){
                   out[manager[id]]--;
                    if(out[manager[id]]==0){
                        q.offer(manager[id]);
                        vis[manager[id]]=true;
                    }
                }
        }
        return time[headID];
    }
}