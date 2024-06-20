class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int ans=-1,mid;
        int min=1,max = 10000000;
        while(min<=max){
            mid = (min+max)/2;
            if(canReach(dist,mid,hour)){
                ans = mid;
                max=mid-1;
            }
            else min = mid+1;
        }
        return ans;
    }
    
    public boolean canReach(int[] dist,int speed,double hour){
        double time=0;
        for(int i=0;i<dist.length-1;i++){
            time+=Math.ceil(dist[i]/(double)speed);
        }
        time+= (dist[dist.length-1])/(double)speed;
        return time<=hour;
    }
}