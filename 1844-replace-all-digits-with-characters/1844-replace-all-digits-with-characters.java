class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for(int i=1;i<s.length();i+=2){
            arr[i] = shift(s.charAt(i-1),Integer.parseInt(""+s.charAt(i)));
        }
        return new String(arr);
    }
    
    public char shift(char c,int i){
       return c = (char)('a'+(c-'a'+i)%26);
    }
}