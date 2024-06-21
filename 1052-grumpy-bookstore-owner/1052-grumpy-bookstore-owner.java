class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)ans+=customers[i];
        }
        int sum = 0,fsum=0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1)sum+=customers[i];
        }
        fsum = Math.max(fsum,sum);
        for(int i=minutes;i<customers.length;i++){
            if(grumpy[i-minutes]==1)sum-=customers[i-minutes];
            if(grumpy[i]==1)sum+=customers[i];
            fsum = Math.max(fsum,sum);
        }
        return ans+fsum;
    }
}