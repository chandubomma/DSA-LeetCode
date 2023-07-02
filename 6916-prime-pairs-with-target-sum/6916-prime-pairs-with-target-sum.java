class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] seive = createSeive(n);
        ArrayList<List<Integer>> list = new ArrayList<>();
        
        for(int i=2;i<=n/2;i++){
            if(seive[i] && seive[n-i]){
                 ArrayList<Integer> list2 = new ArrayList<>();
                list2.add(i);list2.add(n-i);
                list.add(list2);
            }
        }
        return list;
    }
    
    public boolean[] createSeive(int n){
        boolean[] seive = new boolean[n+1];
        Arrays.fill(seive,true);
        seive[0]=seive[1]=false;
        for(int i=2;i*i<=n;i++){
            if(seive[i]){
                for(int j=i*i;j<=n;j+=i){
                    seive[j]=false;
                }
            }
        }
        return seive;
    }
}