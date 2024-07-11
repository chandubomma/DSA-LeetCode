class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(c==')'){
                while(st.peek()!='('){
                    q.offer(st.pop());
                }
                st.pop();
                while(q.size()>0){
                    st.push(q.poll());
                }
                
            }else st.push(c);
        }
        StringBuilder str = new StringBuilder();
        while(st.size()>0)str.append(st.pop());
        return str.reverse().toString();
    }
}