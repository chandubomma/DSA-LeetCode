class Solution {
    public boolean buddyStrings(String s, String goal) {
        int count=0;
        if(s.length()!=goal.length())return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i))count++;
            if(count>2)return false;
        }
        if(count==1)return false;
        if(count==0){
            HashMap<Character,Boolean> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.get(s.charAt(i))==null)map.put(s.charAt(i),true);
                else if(map.get(s.charAt(i))==true)return true;
            }
            return false;
        }
        int[] arr=new int[2];int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                arr[j]=i;
                j++;
            }
        }
        if(s.charAt(arr[0])==goal.charAt(arr[1]) && s.charAt(arr[1])==goal.charAt(arr[0]))return true;
        return false;
    }
}