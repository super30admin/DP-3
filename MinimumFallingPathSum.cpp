//Time Complexity O(numberOfCoins*amount)
//Space Complexity O(numberOfCoins*amount)

// Problem successfully compiled on leetcode
// No Problems faced while figuring out the logic

#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    int minFallingPathSum(vector<vector<int> >& matrix) {
        int rows=matrix.size();
        int cols=matrix[0].size();
    
        for(int row=rows-2;row>=0;row--)
        {
            for(int col=0;col<cols;col++)
            {
                matrix[row][col]+=findMin(matrix,row,col);
            }
        }
        
        int minm=INT_MAX;
        for(int j=0;j<cols;j++)
        {
            if(matrix[0][j]<minm)
            {
                minm=matrix[0][j];
            }
        }
        return minm;
    }
    
    int findMin(vector<vector<int> >& matrix,int row,int col)
    {
        if(col==0)
        {
            return min(matrix[row+1][col],matrix[row+1][col+1]);
        }
        if(col==matrix[0].size()-1)
        {
            return min(matrix[row+1][col],matrix[row+1][col-1]);
        }
        return min(matrix[row+1][col-1],min(matrix[row+1][col],matrix[row+1][col+1]));
    }
};