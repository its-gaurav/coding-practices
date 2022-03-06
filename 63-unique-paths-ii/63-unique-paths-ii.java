class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] t = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                t[i][j] = -1;
            }
        }
        
        return test(obstacleGrid, m, n, 0, 0, t);
    }
    
    int test(int[][] obstacleGrid, int m, int n, int i, int j, int[][] t){
        // if number of paths from i,j to (m-1,n-1) already calculated
        if(t[i][j]!=-1){
            return t[i][j]; 
        }
        // if any path across x and y crosses range, thn reaching destination is not possible
        if(i>=m || j>=n){ 
            return 0;
        }
        // if there is an obstacle, thn this path cannot be taken
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        // if we are at destination, thn this is one of the paths
        if(i==m-1 && j==n-1){ // if x and y reaches m-1 and n-1 which is the destination
            return 1;
        }
        // number of paths if we go down from current (i,j)
        int c1 = test(obstacleGrid, m, n, i+1, j, t);
        // number of paths if we go right from current (i,j)
        int c2 = test(obstacleGrid, m, n, i, j+1, t);
        // total number of paths to reach (m-1,n-1) from current (i,j)
        t[i][j] = c1+c2;
        return t[i][j];
    }
}