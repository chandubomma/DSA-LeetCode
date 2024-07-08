class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Stack<Integer> st = new Stack<>();
        for(char c : s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for(int i : freq.values()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int prev=1,ans=0,c;
        for(int k : map.keySet()){
            while(prev<k){
                if(map.getOrDefault(prev,0)==0)
                st.push(prev);
                prev++;
            }
            c=map.get(k);
            while(c>1){
                if(st.size()>0){
                    ans=ans+k-st.pop();
                }else ans+=k;
                c--;
            }
        }
        return ans;
    }
}