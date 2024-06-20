class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long high = (long)ranks[ranks.length-1]*cars*cars;
        long low = 1,mid,ans=high;
        while(low<=high){
            mid=(low+high)/2;
            if(canRepair(ranks,mid,cars)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    
    public boolean canRepair(int[] ranks,long time,int n){
        long count=0;
        for(int i : ranks){
            count+= (long)Math.sqrt(time/i);
        }
        return count>=n;
    }
}