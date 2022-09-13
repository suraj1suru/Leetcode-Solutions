class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //questions means hight value of column is same
        //questions means hight value of row is same
        //select those have minimum
        
        int result = 0;
        int n = grid.length;
        
        int[] max_row_val = new int[n];
        int[] max_columns_val = new int[n];
        
        for(int i =0; i<n; i++){
            for(int j = 0; j <n; j++){
               max_row_val[i]  = Math.max(max_row_val[i], grid[i][j]);
               max_columns_val[j] =  Math.max(max_columns_val[j], grid[i][j]);
            }
        }
        
        //in this we select minimum value in btw the row and columns value and minus original grid value to get answer 
            for(int i =0; i<n; i++){
                for(int j = 0; j <n; j++){
                result += Math.min(max_row_val[i],max_columns_val[j]) - grid[i][j];
              }
            }
        return result;
    }
}          