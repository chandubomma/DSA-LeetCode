class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder s = new StringBuilder("");
        Stack<Character> st= new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && st.peek()>num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
       while(k>0 && !st.isEmpty()){
           st.pop();
           k--;
       }
        while(!st.isEmpty())s.append(st.pop());
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)=='0'){
            s.delete(i,i+1);
            i--;
        }
        if(s.length()==0)return "0";
        return s.reverse().toString();
    }
}