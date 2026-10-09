class Solution {
    public int minInsertions(String s) {
        String replacedStr = s.replace("))", "1");
        int single = 0;
        for(int i = 0; i<replacedStr.length(); i++){
            if(replacedStr.charAt(i) == ')'){
                single++;
            }
        }
        String str = replacedStr.replace("1", ")");
        System.out.println(str);
        int left = 0, right = 0, ans = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                left++;
            } else {
                right++;
                if(left == right){
                    right = 0;
                    left = 0;
                }else if(right > left){
                    ans+= right - left;
                    right = left;
                }
            }
        }
        left = 0; right = 0;
        for(int i = str.length() - 1; i>=0; i--){
                if(str.charAt(i) == ')'){
                    right++;
                }else{
                    left++;
                    if(left == right){
                        right = 0;
                        left = 0;
                    }else if(right < left){
                        ans+= 2*(left - right);
                        left = right;
                    }
                }
            }
        return ans+single;
    }
}