class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i: students)q.offer(i);
        int i=0,count=0;
        while(i<sandwiches.length && count<=q.size()){
            if(sandwiches[i]==q.peek()){
                q.remove();
                i++;
                count=0;
                continue;
            }
            q.offer(q.remove());
            count++;
        }
        return q.size();
    }
}