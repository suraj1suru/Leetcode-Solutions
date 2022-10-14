class Solution {
    boolean visited[][];
    int col;
    int colorr;

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        //basically we will to the given node and appy dfs
        //while applying dfs we will count the number of calls
        //jis bhi node se 4 calls lagi hongi usse change nhi krna hai
        //baki sab ko color se paint krdo
        col = grid[r0][c0];
        colorr = color;
        visited = new boolean[grid.length][grid[0].length];
        dfs(r0, c0, grid);
        return grid;
    }

    public void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        int count = 0;
        visited[i][j] = true;
        grid[i][j] = colorr;

        if (i + 1 < grid.length && (grid[i + 1][j] == col || visited[i + 1][j])) {
            count++;
            if (!visited[i + 1][j]) dfs(i + 1, j, grid);
        }
        if (i - 1 >= 0 && (grid[i - 1][j] == col || visited[i - 1][j])) {
            count++;
            if (!visited[i - 1][j]) dfs(i - 1, j, grid);
        }
        if (j + 1 < grid[0].length && (grid[i][j + 1] == col || visited[i][j + 1])) {
            count++;
            if (!visited[i][j + 1]) dfs(i, j + 1, grid);
        }
        if (j - 1 >= 0 && (grid[i][j - 1] == col || visited[i][j - 1])) {
            count++;
            if (!visited[i][j - 1]) dfs(i, j - 1, grid);
        }
        if (count == 4) {
            grid[i][j] = col;
        }
    }
}
