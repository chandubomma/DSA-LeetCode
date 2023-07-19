class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(int[] a,int[] b)->Integer.compare(a[0],b[0]));
        int i=1,count=0;
        while(i<intervals.length){
            if(intervals[i][0]<intervals[i-1][1]){
                if(intervals[i-1][1]<intervals[i][1]){
                     intervals[i][0]=intervals[i-1][0];
                    intervals[i][1]=intervals[i-1][1];
                }
                count++;
            }
            i++;
        }
        return count;
    }
}