class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minElement = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;
        for(int i = 0; i<n; i++){
            if(minElement > nums[i]){
                minElement = nums[i];
                minIndex = i+1;
            }
            if(maxElement < nums[i]){
                maxElement = nums[i];
                maxIndex = i+1;
            }
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);
        int ans = Math.min(n - right + 1 + left, n - left + 1);
        return Math.min(right, ans);
    }
}