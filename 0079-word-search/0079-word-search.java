class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(match(board,word,i,j,0))return true;
            }
        }
        return false;
    }
    
    public boolean match(char[][] board,String word,int i,int j,int n){
        if(n>=word.length())return true;
        if(i<0 || i>=board.length || j<0 || j>=board[i].length)return false;
        if(board[i][j]!=word.charAt(n) || board[i][j]=='*')return false;
            char ch = board[i][j];
            board[i][j]='*';
            boolean one =  match(board,word,i,j+1,n+1);
            boolean two =   match(board,word,i+1,j,n+1);
            boolean three = match(board,word,i,j-1,n+1);
            boolean four =  match(board,word,i-1,j,n+1);
            board[i][j]=ch;
            return(one||two||three||four);
    }
}