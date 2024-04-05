class Solution {
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder(s);
        int i=0;
        while(i<str.length()-1){
            if(Math.abs(str.charAt(i)-str.charAt(i+1))==32){
                str.delete(i,i+2);
                if(i>0)i--;
            }else i++;
        }
        return str.toString();
    }
}