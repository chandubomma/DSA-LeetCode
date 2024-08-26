class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums2[i])st.pop();
            if(st.isEmpty())nge[i]=-1;
            else nge[i] = st.peek();
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    ans[i] = nge[j];
                    break;
                }
            }
        }
        return ans;
    }
}