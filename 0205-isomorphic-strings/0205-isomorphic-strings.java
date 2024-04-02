class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
                if(map.getOrDefault(s.charAt(i),null)==null ){
                    if(map2.getOrDefault(t.charAt(i),null)==null){
                         map.put(s.charAt(i),t.charAt(i));
                         map2.put(t.charAt(i),s.charAt(i));
                    }else return false;
                }else if(map.get(s.charAt(i))!=t.charAt(i))return false;
        }
        return true;
    }
}