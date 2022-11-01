//summary of question 
// in grid i,j - 1 -> move right
//in grid i, j = -1 -> move left
// if form v shape break push to array // fas gye hai vhaa

class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] ans = new int[m];
        
        for(int j=0; j<m; j++){
            int cpos = j;
            int npos = -1;
            
            for(int i =0; i<n; i++){
                npos = cpos + grid[i][cpos];
                
                if(npos<0 || npos>= m || grid[i][cpos] != grid[i][npos]){
                    cpos = -1;
                    break;
                }
                cpos = npos;
            }
            
            ans[j] = cpos;
        }
        
        return ans;
    }
}