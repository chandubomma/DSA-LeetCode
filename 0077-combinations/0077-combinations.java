class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
         c(list,list2,n,k,1);
        return list;
    }
    public void c(List<List<Integer>> list,List<Integer> list2,int n,int k,int i){
        if(list2.size()==k){
            list.add(new ArrayList<>(list2));
            return;
        }
        if(i>n)return;
        list2.add(i);
        c(list,list2,n,k,i+1);
        list2.remove(list2.size()-1);
        c(list,list2,n,k,i+1);
        return;
    }
}