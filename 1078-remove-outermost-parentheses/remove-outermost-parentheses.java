class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        Deque<Integer> stk = new ArrayDeque<>();
        String str = "";
        for(int i=0; i<n; i++){
            if(stk.isEmpty()){
                stk.push(i);
            }else{
                if(s.charAt(i) == ')' && s.charAt(stk.peek()) == '(' && stk.size() == 1){
                    String extract = s.substring(stk.peek()+1, i);
                    str+=extract;
                    stk.pop();
                } else if(s.charAt(i) == ')' && s.charAt(stk.peek()) == '('){
                    stk.pop();
                } else{
                    stk.push(i);
                }
            }
        }
        return str;
    }
}