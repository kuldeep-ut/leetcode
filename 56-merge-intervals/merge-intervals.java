class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stk = new Stack<>();
        stk.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] top = stk.peek();

            if (intervals[i][0] <= top[1]) {
                top[1] = Math.max(top[1], intervals[i][1]);
            } else {
                stk.push(intervals[i]);
            }
        }

        int[][] ans = new int[stk.size()][2];
        for (int i = stk.size() - 1; i >= 0; i--) {
            ans[i] = stk.pop();
        }

        return ans;
    }
}