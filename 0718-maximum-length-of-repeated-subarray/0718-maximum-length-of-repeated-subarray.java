class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int i=0,j,p,q,len=0;
        while(i<nums1.length){
            p=0;q=0;j=i;
            while(q<nums2.length && j<nums1.length){
               if(nums2[q]!=nums1[j]){
                   len=Math.max(len,q-p);
                   p++;q=p;j=i;
               }else{
                   q++;j++;
               }
            }
            len=Math.max(len,q-p);
            i++;
        }
        return len;
    }
}