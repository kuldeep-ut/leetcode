class Solution {
    public int reverseDegree(String s) {
        int sum = 0, dig = 26;
        for(int i = 0; i<s.length(); i++){
            //System.out.println(dig - (s.charAt(i) - 'a'));
            sum += (26 - (s.charAt(i) - 'a'))*(i+1);
        }
        return sum;
    }
}