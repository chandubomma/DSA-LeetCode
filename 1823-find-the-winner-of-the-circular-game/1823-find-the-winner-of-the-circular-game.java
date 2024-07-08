class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] lost = new boolean[n];
        int count=0,i=0,j;
        while(count<n-1){
            while(lost[i])i=(i+1)%n;
            j=k;
            while(j>1){
                    if(!lost[i]){
                    j--;
                }
                i=(i+1)%n;
            }
            while(lost[i])i=(i+1)%n;
            lost[i]=true;
            count++;
        }
        for(int p=0;p<n;p++){
            if(!lost[p])return p+1;
        }
        return -1;
    }
}