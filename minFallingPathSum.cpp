// Recursive TLE
// Time Complexity : O(n*3^n) // Give square matrix; done once for each el in top row and at each element max 3 options - left,down,right
// Space Complexity : O(n) // recursive stack; 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: AT EACH INDEX, CALL DFS FROM INDEX-1 TO INDEX+1

// Your code here along with comments explaining your approach
// 1. Recursive solution - call recursive function for each element in top row
// 2. Each step, call dfs on indices from index-1 to index+1 with checks for index in base condition
// 3. If we reach beyond last row, update global min


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        if(A.size() == 0)
            return 0;
        int minSum = INT_MAX;
        for(int idx=0;idx<A.size();idx++)
            dfs(A,0,idx,0,minSum);
        
        return minSum;
    }
    
    void dfs(vector<vector<int>>& A, int row, int index, int sum, int& minSum){
        // base
        if(row == A.size()){
            minSum = min(minSum, sum);
            return;
        }
        if(index>=A[0].size() || index<0 || row> A.size())
            return;
        
        // logic
        for(int j=index-1;j<=index+1;j++)
            dfs(A, row+1,j,sum+A[row][index], minSum);
    }
};

// DP Solution
// Time Complexity : O(n^2) 
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: EACH ELEMENT IN CACHE MATRIX EQUALS CURR VAL + MIN FROM NEIGHBORS IN PREV ROW

// Your code here along with comments explaining your approach
// 1. Maintain DP matrix with first row same as input
// 2. From second row onwards fill such that: each element = sum of val at that index in input + min el of neighbors in prev row
// 3. Return min of last row

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        if(A.size() == 0)
            return 0;
        int minSum = INT_MAX;
        vector<vector<int>> cache(A.size(),vector<int>(A[0].size(),0));
        int m = cache.size(),n=cache[0].size();
        // copy first row as is
        for(int j=0;j<n;j++)
            cache[0][j] = A[0][j];
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                minSum = INT_MAX;
                // find min from prev row
                for(int k=j-1;k<=j+1;k++)
                    if(k>=0 && k<n)
                        minSum= min(minSum, cache[i-1][k]);
                // update curr sum
                cache[i][j] = A[i][j] + minSum;
            }
        }
        // find min of last row
        return *min_element(cache[m-1].begin(), cache[m-1].end());
    }
};
    
