class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                while(i<nums1.length && nums1[i]==list.get(list.size()-1))i++;
                while(j<nums2.length && nums2[j]==list.get(list.size()-1))j++;
            }else if(nums1[i]<nums2[j])i++;
            else j++;
        }
        int[] list2 = new int[list.size()];
        System.out.println(list);
        for(int k=0;k<list.size();k++)list2[k]=list.get(k);
        return list2;
        
    }
}