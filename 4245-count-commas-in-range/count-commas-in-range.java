class Solution {
    public int countCommas(int n) {
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(i >= 1000){
                cnt++;
            }
        }
        if(n < 1000){
            return 0;
        }
        return (n/1000 - 1)*1000 + n%1000+1;
    }
}