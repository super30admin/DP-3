//Time Complexity- O(n*n)
//Space Complexity- O(1)

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        
        int n=A.size();
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                
                int minimum=A[i+1][j];
                
                if(j>0){
                    minimum=min(minimum,A[i+1][j-1]);
                }
                if(j<n-1){
                    minimum=min(minimum,A[i+1][j+1]);
                }
                A[i][j]+=minimum;
            }
        }
        
        int ans=INT_MAX;
        for(int i=0;i<n;i++){
            ans=min(ans,A[0][i]);
        }
        return ans;
    }
};