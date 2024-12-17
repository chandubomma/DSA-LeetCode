class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder str = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->Character.compare(b,a));
        for(char c='z';c>='a';c--){
            if(freq[c-'a']>0)pq.offer(c);
        }
        char c;int count=0;
        while(pq.size()>0){
            c = pq.poll();
            count=0;
            while(freq[c-'a']>0){
                if(count==repeatLimit){
                    if(pq.size()==0)return str.toString();
                    freq[pq.peek()-'a']--;
                    str.append(""+pq.peek());
                    if(freq[pq.peek()-'a']==0)pq.poll();
                    count=0;
                }
                str.append(""+c);count++;
                freq[c-'a']--;
            }
        }
        return str.toString();
    }
}