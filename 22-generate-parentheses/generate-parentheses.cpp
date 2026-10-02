class Solution {
public:
     void solve(string s, int i, int open, int close, int n,vector<string>& ans){
         if(open==0 and close==0){
             ans.push_back(s);
         }
         if(open<close){
            
             solve(s+')',i+1,open, close-1, n, ans);
             
         }
         if(open>0){
        
            solve(s+'(',i+1,open-1, close, n, ans);
            
         }
         
         
     }
    vector<string> generateParenthesis(int n) {
        string s="(";
        int i=0;
        vector<string> ans;
        solve(s,1,n-1,n,n,ans);
        return ans;
    }
};