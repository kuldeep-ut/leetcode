class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int firstHalf = 0, secondHalf = 0;
        int cntLeft = 0, cntRight = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                if (i < n / 2) cntLeft++;
                else cntRight++;
            } else {
                if (i < n / 2) firstHalf += (c - '0');
                else secondHalf += (c - '0');
            }
        }
        int totalQ = cntLeft + cntRight;
        if (totalQ % 2 != 0) {
            return true; 
        }
        int diff = firstHalf - secondHalf;
        int qDiff = cntRight - cntLeft;
        boolean bobWins = (diff == (qDiff / 2) * 9);
        return !bobWins;
    }
}