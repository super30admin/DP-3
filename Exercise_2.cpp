// Time Complexity                              :  O(n)
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if(n == 1) return matrix[0][0];
        
        int gmn = INT_MAX;
        for(int i=1;i<n;i++) {
            for(int j=0;j<n;j++) {
                int mn = INT_MAX;
                // case 1
                if(j-1 >= 0) {
                    mn = min(mn, matrix[i-1][j-1]);
                }
                // case 2
                if(j+1 < n) {
                    mn = min(mn, matrix[i-1][j+1]);
                }
                
                // case 3
                mn = min(mn, matrix[i-1][j]);
                
                // add the miniumum obtained from the three column indices in the previous row
                // as calculated above to the current element
                matrix[i][j] += mn;
                
                // in the last row, figure out the minimum element.
                if(i == n-1) {
                    gmn = min(gmn, matrix[i][j]);
                }
            }
        }
        
        return gmn;
    }
};