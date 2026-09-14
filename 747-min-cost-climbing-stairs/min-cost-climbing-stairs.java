class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return Math.min(solve(cost, 0, cost.length, dp), solve(cost, 1, cost.length, dp));
    }

    int solve(int[] cost, int i, int n, int[] dp) {
        if (i >= n) return 0;
        if(dp[i] != Integer.MAX_VALUE){
            return dp[i];
        }
        return dp[i] = cost[i] + Math.min(solve(cost, i + 1, n, dp), solve(cost, i + 2, n, dp));
    }
}