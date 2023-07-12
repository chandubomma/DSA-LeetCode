class Solution {
    public int reverse(int x) {
        long y=(1L<<31);
        if(x>=0){
            StringBuilder str = new StringBuilder(Integer.toString(x));
            str.reverse();
            long z=Long.parseLong(str.toString());
            if(z>=y)return 0;
            else return (int)z;
        }
        long z=x;
         StringBuilder str = new StringBuilder(Long.toString(z));
            str.reverse();
            z=Long.parseLong(str.substring(0,str.length()-1));
            y=-1*(1L<<31);
            z=-1*z;
            if(z<y)return 0;
            else return (int)z;
    }
}