class Solution {
    public boolean isValid(String s) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(stk.isEmpty()){
                stk.add(i);
            }else{
                if(s.charAt(stk.peek()) == '(' && s.charAt(i) == ')'){
                    stk.pop();
                } else if(s.charAt(stk.peek()) == '{' && s.charAt(i) == '}'){
                    stk.pop();
                }else if(s.charAt(stk.peek()) == '[' && s.charAt(i) == ']'){
                    stk.pop();
                }else{
                    stk.add(i);
                }
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
}