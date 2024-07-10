class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        Pair p;
        for(char c : s.toCharArray()){
                if(st.size()>0 && st.peek().c==c){
                    if(st.peek().freq==k-1){
                        st.pop();
                    }else{
                        p = st.pop();
                        p.freq +=1;
                        st.push(p);
                    }
                }else{
                    st.push(new Pair(c,1));
                }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            p = st.pop();
            for(int i=0;i<p.freq;i++)str.append(p.c);
        }
        return str.reverse().toString();
    }
    
    class Pair{
        char c;
        int freq;
        public Pair(char c,int freq){
            this.c = c;
            this.freq = freq;
        }
    }
}