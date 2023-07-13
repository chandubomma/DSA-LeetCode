class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Num[] num = new Num[map.size()];int j=0;
        for(int i:map.keySet()){
            num[j++]=new Num(i,map.get(i));
        }
        map.clear();
        PriorityQueue<Num> q = new PriorityQueue<>((a,b)->Integer.compare(a.freq,b.freq));
        for(Num i : num){
            q.offer(i);
            if(q.size()>k)q.poll();
        }
        int[] topk = new int[k];
        for(int i=0;i<k;i++){
            topk[k-i-1]=q.poll().val;
        }
        return topk;
    }
}

class Num{
    int val;
    int freq;
    public Num(){};
    public Num(int val,int freq){
        this.val=val;
        this.freq=freq;
    }
    
}