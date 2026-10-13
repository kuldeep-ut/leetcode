class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] = -1*nums[i];
            }
        }
        Arrays.sort(nums);
        int n = nums.length/2;
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < n){
                ans-= Math.pow(nums[i], 2);
            }else{
                ans+= Math.pow(nums[i], 2);
            }
        }
        return ans;
    }
}