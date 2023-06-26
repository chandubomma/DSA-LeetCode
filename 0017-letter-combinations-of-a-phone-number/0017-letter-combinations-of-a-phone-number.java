class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        getCombination(list,digits,s,0);
        return list;
    }
    
    public void getCombination(List<String> list,String digits,StringBuilder s,int n){
        if(digits.length()==s.length()){
            list.add(s.toString());
            return;
        }
        char[] c = getChars(digits.charAt(n));
        for(int i=0;i<c.length;i++){
            s.append(c[i]);
            getCombination(list,digits,s,n+1);
            s.delete(n,n+1);
        }
    }
    
    public char[] getChars(char c){
        char[] array = new char[3];
        switch(c){
            case '2' :{
                array[0]='a';
                array[1]='b';
                array[2]='c';
                return array;
            }
            case '3' :{
                array[0]='d';
                array[1]='e';
                array[2]='f';
                return array;
            }
            case '4' :{
                array[0]='g';
                array[1]='h';
                array[2]='i';
                return array;
            }
            case '5' :{
                array[0]='j';
                array[1]='k';
                array[2]='l';
                return array;
            }
            case '6' :{
                array[0]='m';
                array[1]='n';
                array[2]='o';
                return array;
            }
            case '7' :{
                char[] arr = new char[4];
                arr[0]='p';
                arr[1]='q';
                arr[2]='r';
                arr[3]='s';
                return arr;
            }
            case '8' :{
                array[0]='t';
                array[1]='u';
                array[2]='v';
                return array;
            }
            case '9' :{
                char[] arr = new char[4];
                arr[0]='w';
                arr[1]='x';
                arr[2]='y';
                arr[3]='z';
                return arr;
            }
        }
        return array;
    }

}