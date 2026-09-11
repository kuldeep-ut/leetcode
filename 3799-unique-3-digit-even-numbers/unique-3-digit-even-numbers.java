class Solution {
    public int totalNumbers(int[] digits) {
        final int NUM_DIGITS = 10;
        int[] freq = new int[NUM_DIGITS];
        int res = 0;
        for (int d : digits) freq[d]++;
        for (int i = 1; i < NUM_DIGITS; i++) {
            for (int j = 0; j < NUM_DIGITS; j++) {
                for (int k = 0; k < NUM_DIGITS; k += 2) {
                    freq[i]--;
                    freq[j]--;
                    freq[k]--;
                    if (freq[i] >= 0 && freq[j] >= 0 && freq[k] >= 0) {
                        res++;
                    }
                    freq[i]++;
                    freq[j]++;
                    freq[k]++;
                }
            }
        }

        return res;
    }
}