class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Job[] jobs = new Job[profit.length];
        for(int i=0;i<profit.length;i++){
            jobs[i]=new Job(difficulty[i],profit[i]);
        }
        Arrays.sort(jobs,(Job a,Job b)->{
            if(a.diff-b.diff==0)return b.profit-a.profit;
            return a.diff-b.diff;
        });
        int[] pre = new int[jobs.length];
        pre[0]=jobs[0].profit;
        for(int i=1;i<jobs.length;i++){
            if(jobs[i].profit>pre[i-1])pre[i]=jobs[i].profit;
            else pre[i]=pre[i-1];
        }
        int ans=0,l,r,mid;
        for(int i:worker){
            l=0;r=worker.length-1;
            while(l<=r){
                mid=(l+r)/2;
                if(jobs[mid].diff==i){
                    r=mid;
                    break;
                }
                else if(i<jobs[mid].diff)r=mid-1;
                else l=mid+1;
            }
            if(r>=0 && r<=pre.length)ans+=pre[r];
        }
        return ans;
    }
    
    class Job{
        int diff;
        int profit;
        public Job(int diff,int profit){
            this.diff = diff;
            this.profit = profit;
        }
    }
}