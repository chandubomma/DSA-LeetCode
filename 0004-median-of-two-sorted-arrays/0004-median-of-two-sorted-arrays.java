class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length)return findMedianSortedArrays(nums2,nums1);
        int cut1,cut2,l1,l2,r1,r2,n1=nums1.length,n2=nums2.length,low=0,high=n1;
        while(low<=high){
            cut1 = (low+high)/2;
            cut2=(n1+n2+1)/2-cut1;
            l1 = (cut1>0 && cut1<=n1)?nums1[cut1-1]:Integer.MIN_VALUE;
            l2=(cut2>0 && cut2<=n2) ?nums2[cut2-1]:Integer.MIN_VALUE;
            r1= (cut1>=0 && cut1<n1)?nums1[cut1]:Integer.MAX_VALUE;
            r2=(cut2>=0 && cut2<n2)?nums2[cut2]:Integer.MAX_VALUE;
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return ((double)Math.max(l1,l2)+Math.min(r1,r2))/2;
                }else{
                    return (double)Math.max(l1,l2);
                }
            }
            else if(l1>r2)high=cut1-1;
            else low=cut1+1;
        }
        return 0.0;
    }
}