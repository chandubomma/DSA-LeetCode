class Solution {
    public String getHint(String secret, String guess) {
        int[] freq = new int[10];
        int bulls=0,cows=0;
        for(int i=0;i<secret.length();i++){
            freq[secret.charAt(i)-'0']++;
        }
        for(int i=0;i<guess.length();i++){
            if(freq[guess.charAt(i)-'0']>0){
                cows++;
                freq[guess.charAt(i)-'0']--;
            }
        }
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)==guess.charAt(i))bulls++;
        }
        cows-=bulls;
        return bulls+"A"+cows+"B";        
    }
}