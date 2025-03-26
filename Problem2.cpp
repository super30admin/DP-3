// Time Complexity : O(n*n) n is #of rows in matrix
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. traverse matrix and update element taking minimum value 
// between element above that element and 2 diagonal elements and add to its current value. 
// 2. minimum value in last row is our answer.


class Solution {
public:
    int mint(int a,int b,int c){
        if(a<b){
            if(a<c){return a;}else{return c;}
        }else{
            if(b<c){return b;}else{return c;}
        }
    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m=matrix.size(),n=matrix[0].size();
        int ans=INT_MAX;
        for(int i=0;i<m;i++){
            if( (ans>matrix[0][i]) ){
                    ans=matrix[0][i];
                }
        }
        if(n==1){
            return ans;
        }
        ans=INT_MAX;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int a,b;
                if(j==0){a=INT_MAX;}else{a=matrix[i-1][j-1];}
                if(j==(m-1)){b=INT_MAX;}else{b=matrix[i-1][j+1];}
                matrix[i][j]=matrix[i][j]+mint(a,matrix[i-1][j],b);
                if( i==(n-1) && (ans>matrix[i][j]) ){
                    ans=matrix[i][j];
                }
                cout<<matrix[i][j]<<' ';
            }
        }
        return ans;
    }
    
};