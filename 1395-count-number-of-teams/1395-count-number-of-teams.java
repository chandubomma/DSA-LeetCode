class Solution {
    public int numTeams(int[] rating) {
        int[] ns = new int[rating.length];
        int[] ng = new int[rating.length];
        Arrays.fill(ns,0);
        Arrays.fill(ng,0);
        for(int i=0;i<rating.length;i++){
            for(int j=i+1;j<rating.length;j++){
                if(rating[j]<rating[i])ns[i]++;
                if(rating[j]>rating[i])ng[i]++;
            }
        }
        int ans=0;
        for(int i=0;i<rating.length;i++){
            for(int j=i+1;j<rating.length;j++){
                if(rating[j]>rating[i]){
                   ans+=ng[j];
                }else{
                    ans+=ns[j];
                }
            }
           
        }
        return ans;
    }
}