class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='#'){
                if(st1.size()>0)st1.pop();
            }else st1.push(c);
        }
         for(char c : t.toCharArray()){
            if(c=='#'){
                if(st2.size()>0)st2.pop();
            }else st2.push(c);
        }
        if(st1.size()!=st2.size())return false;
        while(st1.size()>0){
            if(st1.pop()!=st2.pop())return false;
        }
        return true;
    }
}