class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i=0;i<startTime.length;i++){
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs,(a,b)->{return a.et-b.et;});
        HashMap<Integer,Integer> dp = new HashMap<>();
        solve(jobs,0,dp);
        return dp.get(jobs[jobs.length-1].et);
    }
    
    public void solve(Job[] jobs,int n,HashMap<Integer,Integer> dp){
        if(n==jobs.length)return;
        if(n==0){
            dp.put(jobs[0].et,jobs[0].pf);
            solve(jobs,n+1,dp);
            return;
        }
        if(jobs[n].st>=jobs[n-1].et){
            dp.put(jobs[n].et,dp.get(jobs[n-1].et)+jobs[n].pf);
            solve(jobs,n+1,dp);
            return;
        }
        int ind = getInd(jobs,0,n-1,jobs[n].st);
        int pf=0;
        if(ind!=-1)pf =dp.get(jobs[ind].et);
        pf+=jobs[n].pf;
        dp.put(jobs[n].et,Math.max(dp.get(jobs[n-1].et),pf));
        solve(jobs,n+1,dp);
        return;
    }
    
    public int getInd(Job[] jobs,int low,int high,int key){
        int mid;
        int ans=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(jobs[mid].et<=key){
                ans=mid;
                low=mid+1;
            }else high=mid-1;
        }
        return ans;
    }
    
    class Job{
        int st;
        int et;
        int pf;
        public Job(int st,int et,int pf){
            this.st = st;
            this.et = et;
            this.pf = pf;
        }
    }
}