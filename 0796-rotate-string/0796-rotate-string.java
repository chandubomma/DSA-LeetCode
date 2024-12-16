class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        int i=0,j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<s.length()){
            if(s.charAt(i)==goal.charAt(0))list.add(i);
            i++;
        }
        if(list.size()==0)return false;
       for(int ind:list){
            j=0;i=0;
            while(j<goal.length()){
                if(s.charAt(ind)!=goal.charAt(j)){
                    break;
                }
                j++;i++;
                ind=(ind+1)%s.length();
            }
            if(i==s.length())return true;
       }
        return false;
    }
}