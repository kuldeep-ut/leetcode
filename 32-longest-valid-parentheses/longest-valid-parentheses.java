class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxRes = -1;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
                if(right == left) maxRes = Math.max(2*left, maxRes);
                else if(right > left) left = right = 0;
            }
        }
        left = right = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ')'){
                right++;
            }else{
                left++;
                if(right == left) maxRes = Math.max(2*left, maxRes);
                else if(left > right) left = right = 0;
            }
        }
        return maxRes == -1 ? 0 : maxRes;
    }
}