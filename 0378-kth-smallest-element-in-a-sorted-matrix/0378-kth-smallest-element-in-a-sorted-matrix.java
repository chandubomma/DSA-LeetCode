class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0],high=matrix[n-1][n-1],mid,count;
        boolean ispresent;
        while(low<=high){
            ispresent=false;count=0;
            mid=(int)((long)low+high)/2;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]<=mid)count++;
                    if(matrix[i][j]==mid)ispresent=true;
                }
            }
            if(count==k && ispresent)return mid;
            else if(count>=k)high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}