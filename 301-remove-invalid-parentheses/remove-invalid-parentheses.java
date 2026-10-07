class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        solve(s, 0, minNeeded(s), ans);
        return new ArrayList<>(ans);
    }

    void solve(String s, int start, int remaining, Set<String> ans) {
        if (remaining == 0) {
            if (minNeeded(s) == 0) ans.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') continue;               // never remove letters
            if (i > start && c == s.charAt(i - 1)) continue;  // skip duplicate choice
            String next = s.substring(0, i) + s.substring(i + 1);
            solve(next, i, remaining - 1, ans);               // next removal at index >= i
        }
    }

    int minNeeded(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left == 0) right++;
                else left--;
            }
        }
        return left + right;
    }
}