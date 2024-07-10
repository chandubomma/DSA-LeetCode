class Solution {
    public String removeStars(String s) {
        int i = s.length()-1,skip=0;
        StringBuilder str = new StringBuilder();
        while(i>=0){
            while(i>=0){
                if(s.charAt(i)=='*'){
                    skip++;i--;
                }else if(skip>0){
                    skip--;i--;
                }else break;
            }
           if(i>=0)str.append(""+s.charAt(i));
            i--;
        }
        return str.reverse().toString();
    }
}