class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char c;int len=0;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i : map.values()){
            if(i%2==0)len+=i;
            else if(i!=1)len+=i-1;
        }
        if(len<s.length())len++;
        return len;
    }
}