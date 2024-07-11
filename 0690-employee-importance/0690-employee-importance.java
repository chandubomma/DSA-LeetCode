/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee[] es = new Employee[2001];
        for(Employee e : employees){
            es[e.id] = e;
        }
        Queue<Employee> q = new LinkedList<>();
        q.offer(es[id]);
        int ans = 0;Employee e;
        while(q.size()>0){
            e = q.poll();
            ans+=e.importance;
            for(int i : e.subordinates)q.offer(es[i]);
        }
        return ans;
    }
}