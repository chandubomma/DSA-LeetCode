class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> q = new PriorityQueue<>((Project a,Project b)->{return b.profit-a.profit;});
        Project[] p = new Project[profits.length];
        for(int i=0;i<profits.length;i++){
            p[i] = new Project(profits[i],capital[i]);
        }
        Arrays.sort(p,(Project a,Project b)->{return a.capital-b.capital;});
        int i=0;
        while(i<p.length && p[i].capital<=w){
            q.add(p[i]);
            i++;
        }
        int ans = 0;Project t;
        while(q.size()>0 && k-->0){
            t = q.poll();
            w += t.profit;
            while(i<p.length && p[i].capital<=w){
                q.add(p[i]);
                i++;
            }
        }
        return w;
    }
    
    class Project{
        int profit;
        int capital;
        public Project(int p,int c){
            profit = p;
            capital = c;
        }
    }
}