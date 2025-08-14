#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
Using the dp matrix we modify the input and store the minimum in dp and
then again traverse the matrix again to get the minimum falling sum 
*/
class Solution{
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n=matrix.size();
        int m=matrix[0].size();
        vector<vector<int>> dp(n,vector<int>(m,0));

        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int j=1;j<n;j++){
            for(int i=0;i<m;i++){
                int ld=1e9,rd=1e9;
                int up=matrix[j][i] + dp[j-1][i];

                if(i-1>=0)
                    ld=matrix[j][i] + dp[j-1][i-1];
                if(i+1<m)
                    rd=matrix[j][i] + dp[j-1][i+1];

                dp[j][i] = min(up,min(ld,rd));
            }
        }
        int mini=dp[n-1][0];
        for(int i=1;i<m;i++){
            mini=min(mini,dp[n-1][i]);
        }
        return mini;
    }
};
