class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder str = new StringBuilder();
        long[] sf  = new long[shifts.length];
        for(int i=shifts.length-1;i>=0;i--){
            sf[i] = shifts[i];
        }
        for(int i=shifts.length-2;i>=0;i--){
            sf[i] += sf[i+1];
        }
        char c;
        for(int i=0;i<s.length();i++){
            c =(char)('a'+(s.charAt(i)-'a'+sf[i])%26);
            str.append(c);
        }
        return str.toString();
    }
}