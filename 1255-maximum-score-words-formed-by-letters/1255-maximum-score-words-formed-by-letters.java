class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int i=0,var1;
        HashMap<Character,Integer> freq = new HashMap<>();
        while(i<letters.length){
            freq.put(letters[i],freq.getOrDefault(letters[i],0)+1);
            i++;
        }
        int[] ans = new int[1];
        solve(words,score,freq,0,0,ans);
        return ans[0];
    }
    
    public void solve(String[] words,int[] score,HashMap<Character,Integer> freq, int n,int sum,int[] ans){
        if(n>=words.length){
            ans[0]=Math.max(ans[0],sum);
            return;
        }
        solve(words,score,freq,n+1,sum,ans);
        int i=0,j=0;
        String word = words[n];
        while(i<word.length()){
            if(freq.getOrDefault(word.charAt(i),0)>0){
                sum+=score[(int)word.charAt(i)-97];
                freq.put(word.charAt(i),freq.get(word.charAt(i))-1);
            }else {
                j=0;
                while(j<i){
                    freq.put(word.charAt(j),freq.get(word.charAt(j))+1);
                    j++;
                }
                return;
            }
            i++;
        }
        solve(words,score,freq,n+1,sum,ans);
        j=0;
        while(j<word.length()){
            freq.put(word.charAt(j),freq.get(word.charAt(j))+1);
            j++;
        }
        return;
    }
}