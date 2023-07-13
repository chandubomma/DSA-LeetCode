class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<CharFreq> q = new PriorityQueue<>(new customComparator());
        for(int i=0;i<s.length();i++){
           CharFreq cf = new CharFreq(s.charAt(i),map.get(s.charAt(i)));
            q.add(cf);
        }
        StringBuilder str = new StringBuilder("");
        while(q.size()>0){
            str.append(Character.toString(q.poll().c));
        }
        return str.toString();
    }
}

class CharFreq{
    char c;
    int freq;
    public CharFreq(char c,int freq){
        this.c = c;
        this.freq = freq;
    }
}

class customComparator implements Comparator<CharFreq>{
    public int compare(CharFreq c1,CharFreq c2){
        if(Integer.compare(c2.freq,c1.freq)!=0)return Integer.compare(c2.freq,c1.freq);
        return Character.compare(c2.c,c1.c);
    }
}