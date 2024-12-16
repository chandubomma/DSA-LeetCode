class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        char curr=' ';int count=0;
        for(char c:s.toCharArray()){
            if(c==curr)count++;
            else {
                curr=c;
                count=1;
            }
            if(count<=2)str.append(""+c);
        }
        return str.toString();
    }
}