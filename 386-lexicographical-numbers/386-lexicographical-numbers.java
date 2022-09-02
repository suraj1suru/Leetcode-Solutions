class Solution {
    public void dfs(int i, int n,ArrayList <Integer> lexiNumber){
        if(i > n) return;
        
        lexiNumber.add(i);
        for(int j = 0; j < 10; j++)
            dfs(10*i+j, n, lexiNumber);
    }
    
    public List<Integer> lexicalOrder(int n) {
        ArrayList <Integer> lexiNumber = new ArrayList<>();
        
        for(int i = 1; i <=9; i++){
            dfs(i , n, lexiNumber);
        }
        return lexiNumber;
    }
}