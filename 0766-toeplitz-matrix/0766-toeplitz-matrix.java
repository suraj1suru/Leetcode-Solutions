class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        
        for(int i =1; i<n; i++){
            for(int j =1; j<m; j++){
            if(mat[i-1][j-1] != mat[i][j]){
                return false;
            }
            }
        }
        
        return true;
    }
}