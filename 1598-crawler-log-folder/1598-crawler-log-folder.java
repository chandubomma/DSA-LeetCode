class Solution {
    public int minOperations(String[] logs) {
        int level =0;
        for(String s : logs){
            if(s.equals("../") && level>0)level--;
            else if(s.equals("./") || s.equals("../"))continue;
            else level++;
        }
        return level;
    }
}