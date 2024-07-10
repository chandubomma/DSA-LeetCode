class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int a,b;
        for(String s : operations){
            if(s.equals("+")){
                a = st.pop();
                b = st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
            }
            else if(s.equals("C"))st.pop();
            else if(s.equals("D")){
                st.push(2*st.peek());
            }
            else st.push(Integer.parseInt(s));
        }
        a=0;
        while(!st.isEmpty())a+=st.pop();
        return a;
    }
}