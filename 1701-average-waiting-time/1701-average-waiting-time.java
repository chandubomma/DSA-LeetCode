class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime=0,arrival,time,waitingTime=0;
        for(int i=0;i<customers.length;i++){
            arrival = customers[i][0];
            time = customers[i][1];
            if(currentTime>arrival){
                currentTime+=time;
            }else {
                currentTime = arrival+time;
            }
            waitingTime+=(currentTime-arrival);
        }
        return (double)waitingTime/(double)customers.length;
    }
}