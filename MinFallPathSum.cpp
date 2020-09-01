// T : O(N^2)
//S : O(1)

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        if(A.size()==0 || A[0].size()==0) return 0;
        
        
        for(int i=1;i<A.size();i++){
            for(int j=0;j<A[i].size();j++){
                if(j==0){
                  A[i][j]+=  min(A[i-1][j], A[i-1][j+1]);
                }
                else if(j==A[i].size()-1){
                   A[i][j]+= min(A[i-1][j-1], A[i-1][j]);
                }
                else{
                    A[i][j]+=min(min(A[i-1][j-1], A[i-1][j+1]), A[i-1][j]);
                }
            }
        }
        int mn = INT_MAX;
        for(auto num: A[A.size()-1]){
            mn = min(num,mn);
        }
        return mn;
    }
};