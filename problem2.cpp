// Time Complexity : O(n^2) --> We iterate through the array for every row (except last) while checking for column on each iteration 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Had some trouble understanding algorithm then finding out all the edge cases


// Your code here along with comments explaining your approach

/*
1. The basic approach here is to iterate through the array starting from second last row & first column to first row [bottom up approach].
2. Update the array by checking for minimum on every iteration and adding it to the existing minimum Value from bottom to top.
3. There are 3 overflow situations to be handled (when array size is 1, left column doesn't exist, right column doesn't exist).
*/


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int size = A.size();
        
        for(int row = size-2; row >= 0; row-- )
        {
            for(int column = 0; column < size; column++)
            {
                int currentMinimum = A[row + 1][column];
                
                if(column > 0) //prevents moving towards left and overflowing for first column 
                    currentMinimum = min(currentMinimum, A[row + 1][column -1]);
                
                if(column + 1 < size) //check for the minimum value if right column exists
                    currentMinimum = min(currentMinimum, A[row + 1][column+1]);
                
                A[row][column] += currentMinimum; //add the minimum before every iteration
            }
        }
        
        int minimumValue = INT_MAX; 
        
        for(int i: A[0])
            minimumValue = min(minimumValue, i); 
        return minimumValue;
    }         
    
};
