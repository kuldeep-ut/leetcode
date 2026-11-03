class Solution {
    public int minMoves(int[] nums) {
        int mx = -1, sum = 0, n = nums.length;
        for(int x : nums){
            if(mx < x){
                mx = x;
            }
            sum += x;
        }
        return n*mx - sum;
    }
}