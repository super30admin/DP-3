Time Complexity-O(m*n)
Space Complexity-O(1)
Did the code run on Leetcode? yes

#include<bits/stdc++.h>
#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        if(A.size()==0)
        {
            return 0;
        }
        for(int i=1;i<A.size();i++)
        {
            for(int j=0;j<A[0].size();j++)
            {
                if(j==0)
                {
                    A[i][j]+=min(A[i-1][j],A[i-1][j+1]);
                }
                else if(j==A[0].size()-1)
                {
                    A[i][j]+=min(A[i-1][j-1],A[i-1][j]);
                }
                else
                {
                    A[i][j]+=min(min(A[i-1][j-1],A[i-1][j]),A[i-1][j+1]);
                }
            }
        }
        int result=INT_MAX;
        for(int j=0;j<A[0].size();j++)
        {
            if(A[A.size()-1][j]<result)
            {
                result=A[A.size()-1][j];
            }
        }
        return result;
    }
};

int main() {
	vector<vector<int>>m={{1,2,3},{4,5,6},{7,8,9}};
	Solution soln;
	int result=soln.minFallingPathSum(m);
	cout<<result;
	return 0;
}