class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<score.length;i++)q.add(score[i]);
        String[] answer = new String[score.length];int place=0,top;
        while(q.size()>0){
            top=q.poll();
            for(int i=0;i<score.length;i++){
                if(score[i]==top){
                    place++;
                    switch(place){
                        case 1 : {
                            answer[i]="Gold Medal";
                            break;
                        }
                        case 2 : {
                            answer[i]="Silver Medal";
                            break;
                        }
                        case 3 : {
                            answer[i]="Bronze Medal";
                            break;
                        }
                        default : {
                            answer[i]=Integer.toString(place);
                        }
                    }
                }
            }
        }
        return answer;
    }
}