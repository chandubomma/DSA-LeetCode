class Solution {
    public int maxDepth(String s) {
        int d=0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')st.push('(');
            if(s.charAt(i)==')'){
                if(st.peek()=='('){
                    d=Math.max(d,st.size());
                    st.pop();
                   
                }else if(s.charAt(i)=='(')st.push('(');
            }
        }
       return d;
    }
}