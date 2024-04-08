class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int i=0,j=0,count=0;
        while(i<sandwiches.length && count<students.length-i){
            while(students[j]==-1)j=(j+1)%students.length;
           if(sandwiches[i]==students[j]){
               students[j]=-1;
               i++;
               j=(j+1)%students.length;
               count=0;
               continue;
           }
            count++;
            j=(j+1)%students.length;
        }
       return students.length-i;
    }
}