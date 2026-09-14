class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return solve(0, 0, grid.length, grid[0].length, grid, dp);
    }
    int solve(int i, int j, int n, int m, int[][] grid, int[][] dp){
        if(i >= n || j >= m){
            return Integer.MAX_VALUE;
        }
        if(i == n-1 && j == m-1){
            return dp[i][j] = grid[i][j];
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        return dp[i][j] = grid[i][j] + Math.min(solve(i, j+1, n, m, grid, dp), solve(i+1, j, n, m, grid, dp));
    }
}