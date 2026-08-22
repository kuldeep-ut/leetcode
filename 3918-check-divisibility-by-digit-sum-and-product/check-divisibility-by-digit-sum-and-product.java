class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, mult = 1, num = n;
        while(num != 0){
            int rem = num%10;
            sum+= rem;
            mult*= rem;
            num/= 10;
        }
        return n%(mult+sum) == 0 ? true : false;
    }
}