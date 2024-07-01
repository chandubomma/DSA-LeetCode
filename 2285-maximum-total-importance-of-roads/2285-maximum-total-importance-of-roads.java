class Solution {
    public long maximumImportance(int n, int[][] roads) {
       ArrayList<ArrayList<Integer>> degree = new ArrayList<>();
        for(int i=0;i<n;i++){
            degree.add(new ArrayList<>());
            degree.get(i).add(i);
            degree.get(i).add(0);
        }
        for(int[] road:roads){
            degree.get(road[0]).set(1,degree.get(road[0]).get(1)+1);
            degree.get(road[1]).set(1,degree.get(road[1]).get(1)+1);
        }
        
        Collections.sort(degree,(a,b)->Integer.compare(b.get(1),a.get(1)));
        int[] value = new int[n];
        int val = n;
        for(ArrayList<Integer>list : degree){
            value[list.get(0)]=val;
            val--;
        }
        long ans=0;
        for(int[] road: roads){
            ans+=value[road[0]]+value[road[1]];
        }
        return ans;
    }
}