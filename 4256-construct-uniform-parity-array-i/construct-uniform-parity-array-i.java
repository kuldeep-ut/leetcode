class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallest = Integer.MAX_VALUE;
        int cntOdd = 0, cntEven = 0;
        // for(int x: nums1){
        //     smallest = (smallest > x) ? x : smallest;
        //     if(x%2 == 0) {
        //         cntEven++;
        //     } else {
        //         cntOdd++;
        //     }
        // }
        // if(smallest%2 == 0){
        //     if(cntOdd > 1 || cntOdd == 0){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }
        return true;
    }
}