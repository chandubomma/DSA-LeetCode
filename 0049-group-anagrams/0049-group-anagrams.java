class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> list = new ArrayList<>();
        int[] h = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            h[i]=new String(c).hashCode();
        }
        HashSet<Integer> set = new HashSet();
        for(int i : h)set.add(i);
        Iterator it = set.iterator();
        int k;
        while(it.hasNext()){
            ArrayList<String> l = new ArrayList<>();
            k =(int)it.next();
            for(int i=0;i<strs.length;i++){
                if(h[i]==k)l.add(strs[i]);
            }
            list.add(l);
        }
        return list;
    }
}