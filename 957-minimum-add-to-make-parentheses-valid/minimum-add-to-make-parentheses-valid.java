class Solution {
    public int minAddToMakeValid(String s) {
         Deque<Integer> stk = new ArrayDeque<>();
         for(int i = 0; i < s.length(); i++){
            if(stk.isEmpty()){
                stk.push(i);
            } else {
                if(s.charAt(i) == ')' && s.charAt(stk.peek()) == '(')
                    stk.pop();
                else
                    stk.push(i);
            }
         }
         return stk.size();
    }
}