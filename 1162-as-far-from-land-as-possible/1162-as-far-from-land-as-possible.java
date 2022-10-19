class Solution {
     public class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

   
    public int maxDistance(int[][] grid) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1) q.add(new Pair(i,j));
            }
        }
        
        if(q.size() == 0 || q.size() == grid.length*grid[0].length){
            return -1;
        }
      int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        
        int level = -1;
        while(q.size() > 0){
       level++;
            int size = q.size();
            
            while(size --> 0){
                Pair rem = q.remove();
                
                for(int i =0; i<4; i++){
                    int rowdash = rem.row +dirs[i][0];
                    int coldash = rem.col +dirs[i][1];
                    
                   if (rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] == 1) {
                        continue;
                    }
		    
                    q.add(new Pair(rowdash, coldash));
                    grid[rowdash][coldash] = 1;
                }
            }
        }
        return level;
    }
}