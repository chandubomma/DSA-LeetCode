class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Person[] people = new Person[names.length];
        for(int i=0;i<names.length;i++){
            people[i] = new Person(names[i],heights[i]);
        }
        Arrays.sort(people,(p1,p2)->Integer.compare(p2.height,p1.height));
        String[] sortedNames = new String[names.length];
        for(int i=0;i<names.length;i++){
            sortedNames[i] = people[i].name;
        }
        return sortedNames;
    }
    
    class Person{
        String name;
        int height;
        public Person(String name,int height){
            this.name = name;
            this.height = height;
        }
    }
}