class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,Integer> indegree = new HashMap<>();
        HashMap<String,ArrayList<String>> adj = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(int i=0;i<recipes.length;i++){
            for(String s : ingredients.get(i)){
                if(adj.get(s)==null)adj.put(s,new ArrayList<String>());
                adj.get(s).add(recipes[i]);
                indegree.put(recipes[i],indegree.getOrDefault(recipes[i],0)+1);
            }
        }
        for(String s : supplies)q.add(s);
        String s;ArrayList<String> ls;
        while(!q.isEmpty()){
            s = q.poll();
            list.add(s);
            ls = adj.get(s);
            if(ls==null)continue;
            for(int i=0;i<ls.size();i++){
                indegree.put(ls.get(i),indegree.get(ls.get(i))-1);
                if(indegree.get(ls.get(i))==0)q.add(ls.get(i));
            }
        }
        for(int i=supplies.length;i<list.size();i++)ans.add(list.get(i));
        return ans;
    }
}