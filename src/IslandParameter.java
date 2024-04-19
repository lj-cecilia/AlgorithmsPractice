//time O(m^2n^2)
//space O(1)
// public class IslandParameter {
//     public int islandPerimeter(int[][] grid) {
//         for (int i = 0 ; i < grid.length; i++){
//             for (int j = 0 ; j < grid[0].length; j++){
//                 if (grid[i][j] == 1) {  //find island
//                     return getPerimeter(grid,i,j);
//                 }
//             }
//         }
//         return 0;   //didnt find any island
//     }

//     public int getPerimeter(int[][] grid, int i, int j){

//         //reach boundary for find sea, boundary increase 1, no dfs
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {return 1;}

//         //already visit, no action, no dfs
//         if (grid[i][j] == -1) return 0;

//         int count = 0;  //count start from 0
//         grid[i][j] = -1;    //mark as visited
//         //dfs at 4 directions
//         count += getPerimeter(grid, i-1, j);
//         count += getPerimeter(grid, i, j-1);
//         count += getPerimeter(grid, i, j+1);
//         count += getPerimeter(grid, i+1, j);

//         return count;
//     }
// }


//time O(mn)
//space O(1)
class IslandParameter {
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbors = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                //with each new block, add 4 to perimeter
                if (grid[i][j] == 1) {
                    ++islands;
                    //if there is a neighbor in previous encounter, then two sides are wasted
                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                        ++neighbors;
                    //if there is a neighbor in previous encounter, two sides are once again wasted
                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                        ++neighbors;
                }
        //count total and minus wasted
        return islands * 4 - neighbors * 2;
    }
}
