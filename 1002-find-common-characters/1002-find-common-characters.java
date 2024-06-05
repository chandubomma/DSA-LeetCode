class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char c : words[0].toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(int i=1;i<words.length;i++){
            map2.clear();
            for(char c : words[i].toCharArray())map2.put(c,map2.getOrDefault(c,0)+1);
            for(char c : map1.keySet()){
                map1.put(c,Math.min(map1.get(c),map2.getOrDefault(c,0)));
            }
        }
        ArrayList<String> list = new ArrayList<>();
        int freq;
        for(char c : map1.keySet()){
            freq = map1.get(c);
            while(freq-->0)list.add(""+c);
        }
        return list;
    }
}