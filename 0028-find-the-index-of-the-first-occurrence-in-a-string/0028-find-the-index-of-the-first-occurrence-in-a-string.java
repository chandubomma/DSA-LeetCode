class Solution {
    public int strStr(String haystack, String needle) {
        int j=0,k;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            k=i;j=0;
            while(j<needle.length()){
                if(haystack.charAt(k)==needle.charAt(j)){
                    j++;
                    k++;
                }else break;
            }
            if(j==needle.length())return i;
        }
        return -1;
    }
}