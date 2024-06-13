class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder("");
        int minLen=200;
        for(String s : strs)if(s.length()<minLen)minLen = s.length();
        char c;
        for(int i=0;i<minLen;i++){
            c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=c)return str.toString();
            }
            str.append(c);
        }
        return str.toString();
    }
}