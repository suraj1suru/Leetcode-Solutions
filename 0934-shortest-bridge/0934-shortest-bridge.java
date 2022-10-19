class Solution {

    public class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int shortestBridge(int[][] grid) {
        LinkedList<Pair> que = new LinkedList<>();

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        boolean flag = false;

        for (int i = 0; i < grid.length && flag == false; i++) {
            for (int j = 0; j < grid[0].length && flag == false; j++) {
                if (grid[i][j] == 1) {
                    DFS(i, j, grid, que, vis);
                    flag = true;
                }
            }
        }

        int level = 0;
        while (que.size() > 0) {
            int size = que.size();

            while (size-- > 0) {
                Pair rem = que.removeFirst();

                for (int i = 0; i < dir.length; i++) {
                    int rowDase = rem.row + dir[i][0];
                    int colDase = rem.col + dir[i][1];

                    if (rowDase < 0 || colDase < 0 || rowDase >= grid.length || colDase >= grid[0].length || vis[rowDase][colDase] == true) {
                        continue;
                    }

                    if (grid[rowDase][colDase] == 1) {
                        System.out.print(rowDase + colDase + "U");
                        return level;
                    }

                    //   System.out.print( rowDase + colDase + "U");

                    que.addLast(new Pair(rowDase, colDase));
                    vis[rowDase][colDase] = true;
                }
            }

            level++;
            // System.out.print(level);

        }
        return -1;
    }

    // public   int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public void DFS(int i, int j, int[][] arr, LinkedList<Pair> que, boolean[][] vis) {
        vis[i][j] = true;
        que.addLast(new Pair(i, j));

        for (int k = 0; k < dir.length; k++) {
            int rowDase = i + dir[k][0];
            int colDase = j + dir[k][1];

            if (rowDase < 0 || colDase < 0 || rowDase >= arr.length || colDase >= arr[0].length || vis[rowDase][colDase] == true || arr[rowDase][colDase] == 0) {
                continue;
            }

            DFS(rowDase, colDase, arr, que, vis);
        }
    }
}
