class Solution {
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int num;
        for(char c : s.toCharArray()){
            if(c==']'){
                str.setLength(0);
                temp.setLength(0);
                while(st.peek()!='[')str.append(st.pop());
                st.pop();
                while(!st.isEmpty() && st.peek()>='0' && st.peek()<='9'){
                    temp.append(st.pop());
                }
                num = Integer.parseInt(temp.reverse().toString());
                str = str.reverse();
                while(num-->0)
                for(char ch:str.toString().toCharArray())st.push(ch);
            }else st.push(c);
        }
        str.setLength(0);
        while(!st.isEmpty())str.append(st.pop());
        return str.reverse().toString();
    }
}