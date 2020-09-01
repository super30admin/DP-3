//Time Complexity - O(N2) N size of array
//Space Complexity - O(1)

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
                if(A.size()==0)
                    return 0;
                for(int i=1;i<A.size();i++){
                    for(int j=0;j<A.size();j++){
                        if(j==0)
                            A[i][j] = A[i][j] + min(A[i-1][j],A[i-1][j+1]);
                        else if(j==A.size()-1)
                            A[i][j] = A[i][j] + min(A[i-1][j-1],A[i-1][j]);
                        else
                             A[i][j] = A[i][j] + min(A[i-1][j-1],min(A[i-1][j],A[i-1][j+1]));
                    }
                }
                int minSum=INT_MAX;
                for(int i=0;i<A.size();i++)
                    minSum=min(minSum,A[A.size()-1][i]);
                
                return minSum;
    }
};


int main(int argc, const char * argv[]) {
    Solution s;
    vector<vector<int>> nums{{1,2,3},{4,5,6},{7,8,9}};
    
    std::cout << s.minFallingPathSum(nums)<<"\n";
    return 0;
}
