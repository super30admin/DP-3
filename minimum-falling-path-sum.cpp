// Time Complexity - O(nm)
// Space Complexity - O(1)

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int r = A.size(), c = A[0].size();
        vector<int> range = {-1,0,1};
        int minimum = INT_MAX;
        
        
        for(int i=1;i<r;i++){
            for(int j=0;j<c;j++){
            minimum = INT_MAX;
                for(int k=0;k<range.size();k++){
                    if(j+range[k]>=0 && j+range[k]<c){
                        
                        if(minimum>A[i][j]+A[i-1][j+range[k]]){
                            minimum = A[i][j]+A[i-1][j+range[k]]; 
                        }
                        
                    }
                }
                A[i][j] = minimum;
            }
        }
        
        for(int j=0;j<A[r-1].size();j++){
            minimum = min(minimum,A[r-1][j]);  
        }
        return minimum;
    }
};