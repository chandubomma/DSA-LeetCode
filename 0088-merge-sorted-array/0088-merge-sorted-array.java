class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=nums1.length-1;i>=n;i--){
            nums1[i] = nums1[i-n];
        }
        int i=n,j=0,ind=0;
        while(i<nums1.length && j<n){
            if(nums1[i]<=nums2[j]){
                nums1[ind++]=nums1[i++];
            }else {
                nums1[ind++] = nums2[j++];
            }
        }
        while(i<m+n)nums1[ind++]=nums1[i++];
        while(j<n)nums1[ind++] = nums2[j++];
    }
}