class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        boolean f=false;
        for(int i=0;i<s.length();i++){
            if(!f && s.charAt(i)!=' ')count++;
            else if(f && s.charAt(i)!=' '){
                count=1;
                f=false;
            }
            else if(s.charAt(i)==' ')f=true;
            else count++;
        }
        return count;
    }
}