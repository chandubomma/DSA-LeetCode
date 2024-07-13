class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Robot[] rs = new Robot[positions.length];
        for(int i=0;i<positions.length;i++){
            rs[i] = new Robot(positions[i],healths[i],directions.charAt(i));
        }
        Arrays.sort(rs,(r1,r2)->Integer.compare(r1.pos,r2.pos));
        Stack<Robot> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Robot r2;
        for(Robot r1 : rs){
            if(r1.d=='R')st.push(r1);
            else if(!st.isEmpty()){
                if(st.peek().h==r1.h){
                    st.pop();
                    continue;
                }
                if(st.peek().h>r1.h){
                    r2 = st.pop();
                    r2.h-=1;
                    st.push(r2);
                    continue;
                }
                while(st.size()>0 ){
                   if(st.peek().h<r1.h){
                        r1.h-=1;
                        st.pop();
                        if(st.size()==0)map.put(r1.pos,r1.h);
                   }else if(st.peek().h==r1.h){
                       st.pop();
                       break;
                   }else{
                       r2 = st.pop();
                        r2.h-=1;
                        st.push(r2);
                       break;
                   }
                } 
            }else map.put(r1.pos,r1.h);
        }
        while(st.size()>0){
            r2=st.pop();
            map.put(r2.pos,r2.h);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i : positions ){
            if(map.get(i)!=null){
                ans.add(map.get(i));
            }
        }
        return ans;
    }
    
    public class Robot{
        int pos;
        int h;
        char d;
        public Robot(int pos,int h,char d){
            this.pos = pos;
            this.h = h;
            this.d = d;
        }
    }
}