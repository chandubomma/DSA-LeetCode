class Solution {
    public int findTheWinner(int n, int k) {
       Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++)q.offer(i);
        int c;
        while(q.size()>1){
            c=k;
            while(c>1){
                q.offer(q.poll());
                c--;
            }
            q.poll();
        }
        return q.poll();
    }
}