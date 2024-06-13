class Solution {
    public String countAndSay(int n) {
        if(n==1)return "1";
        String s = countAndSay(n-1);
        return rle(s);
    }
    
    public String rle(String s){
        StringBuilder str = new StringBuilder("");
        int count=1;
        char prev= s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev)count++;
            else{
                str.append(""+count+prev);
                count=1;
                prev=s.charAt(i);
            }
        }
        str.append(""+count+prev);
        return str.toString();
    }
    
   
}