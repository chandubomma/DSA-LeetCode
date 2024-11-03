class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        char c1,c2;
        String str = s.toLowerCase();
        while(i<=j){
            c1 = str.charAt(i);
            c2 = str.charAt(j);
            if(!((c1>='a' && c1<='z')||(c1>='0' && c1<='9'))){
                i++;
                continue;
            }
            if(!((c2>='a' && c2<='z')||(c2>='0' && c2<='9'))){
                j--;
                continue;
            }
            if(c1!=c2)return false;
            i++;
            j--;
        }
        return true;
    }
}