class Solution {
    public int countTriplets(int[] arr) {
        int count=0,a,b;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j;k<arr.length;k++){
                    a=b=0;
                    for(int p=i;p<j;p++)a=a^arr[p];
                    for(int q=j;q<=k;q++)b=b^arr[q];
                    if(a==b)count++;
                }
            }
        }
        return count;
    }
}