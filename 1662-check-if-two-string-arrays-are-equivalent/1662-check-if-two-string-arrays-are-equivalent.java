class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = word1.length; 
        int m = word2.length;
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i =0; i<n; i++){
            sb1.append(word1[i]);
        }
        for(int i =0; i<m; i++){
            sb2.append(word2[i]);
        }
        
        String ans1 = sb1.toString();
        String ans2 = sb2.toString();
        
        if(ans1.equals(ans2)) return true;
        
        
        return false;
    }
}