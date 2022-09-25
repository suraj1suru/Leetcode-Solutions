class Solution {
    public int findTheWinner(int n, int k) {
        if(n == 1) return 1;
        int y = findTheWinner(n-1, k);
        int x = (y+k) % n == 0 ? n: (y + k) % n;;
        
        return x;
    }
}