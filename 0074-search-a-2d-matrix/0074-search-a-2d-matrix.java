class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l,h,mid1,mid2,n;
        l=0;h=matrix.length-1;n=matrix[0].length;
        while(l<=h){
            mid1=(l+h)/2;
            if(target>=matrix[mid1][0] && target<=matrix[mid1][n-1]){
                l=0;h=n-1;
                while(l<=h){
                    mid2=(l+h)/2;
                    if(target==matrix[mid1][mid2])return true;
                    else if(target<matrix[mid1][mid2])h=mid2-1;
                    else l=mid2+1;
                }
                return false;                                 
            }
            else if(target<matrix[mid1][0])h=mid1-1;
            else l=mid1+1;
        }
        return false;
    }
}
       