class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        int ans=0,sc;
        char c1,c2;
        if(x>y){
            c1='a';c2='b';sc=x;
        }else{
            c1='b';c2='a';sc=y;
        }
        for(char c : s.toCharArray()){
            if(c==c2 && st.size()>0 && st.peek()==c1){
                st.pop();
                ans+=sc;
            }else st.push(c);
        }
        StringBuilder str = new StringBuilder();
        while(st.size()>0)str.append(st.pop());
        str = str.reverse();
        sc=x+y-sc;
        for(char c : str.toString().toCharArray()){
            if(c==c1 && st.size()>0 && st.peek()==c2){
                st.pop();
                ans+=sc;
            }else st.push(c);
        }
        return ans;
    }
}