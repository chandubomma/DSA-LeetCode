class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(c=='('){
                st.push(c);
                str.append(c);
            }
            else if(c==')'){
                if(!st.isEmpty() && st.peek()=='('){
                    str.append(c);
                    st.pop();
                }
            }else {
                str.append(c);
            }
        }
        while(!st.isEmpty())st.pop();
        StringBuilder str2 = new StringBuilder("");
        for(int i=str.length()-1;i>=0;i--){
             c = str.charAt(i);
            if(c==')'){
                st.push(c);
                str2.append(c);
            }
            else if(c=='('){
                if(!st.isEmpty() && st.peek()==')'){
                    str2.append(c);
                    st.pop();
                }
            }else {
                str2.append(c);
            }
        }
        return str2.reverse().toString();
    }
}