class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int half = n / 2;
        
        String sb1 = s.substring(0,half);
        String sb2 = s.substring(half,n);
        
        
        int ans1 = 0; int ans2 = 0;
        for(int i = 0; i < half; i++){
            char c = sb1.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ){
                ans1++;
            }
        }
        
        for(int i = 0; i < half; i++){
            char ch = sb2.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
                ans2++;
            }
        }
        
        if(ans1 == ans2) return true;
        
        
        return false;
    }
    
}