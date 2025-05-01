/*
    For this question, Breadth First Search or BFS is the best approach to traverse a binary tree level order wise.
        Time Complexity : O(row * col)
        Space Complexity : O(rpw * col)
    
    Explanation:
        We are gonna traverse and check every box in the given grid, If the box has value '1' then we have to add it to the visited array, increment 
        the number of islands and do a BFS till we cover the island area 

*/



class Solution {
    public int numIslands(char[][] grid) {
        int numOfIsland = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    numOfIsland++;
                    bsf(i,j,grid,visited);
                }
            }
        }
        return numOfIsland;
    }

    public void bsf(int row, int col, char[][] grid, boolean[][] visited){

        visited[row][col] = true;

        int[][] directions = {
            {1,0}, {-1,0}, {0,1},{0,-1}
        };

        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{row, col});

        while(!queue.isEmpty()){
            int[] node = queue.pollFirst();
            
            for(int[] dir : directions){
                int r = node[0] + dir[0];
                int c = node[1] + dir[1];

                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1' && !visited[r][c]){
                    visited[r][c] = true;
                    queue.offerLast(new int[]{r,c});
                }
            }
        }
    }
}
