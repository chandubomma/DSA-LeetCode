class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]<tickets[k])time+=tickets[i];
            else {
                if(i<=k)time+=tickets[k];
                else time=time+tickets[k]-1;
            }
        }
        return time;
    }
}