// Time Complexity :o(n^2)
// Space Complexity :0(n) for arraylist.
// Did this code successfully run on Leetcode :Yes.
// Any problem you faced while coding this :yes when it is at egde of the matrix some edge cases failed


// Your code here along with comments explaining your approach:- starting from last but two row and checking various possiblities of minimum under the starting row and minimum value is added and changedfor that row like that we get paths in first rows and getting min from them by storing in arraylist.

import java.util.Collections;
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        ArrayList<Integer>a =new ArrayList<>();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],Math.min(j+1<n?matrix[i+1][j+1]:Integer.MAX_VALUE,j-1>=0?matrix[i+1][j-1]:Integer.MAX_VALUE));
            }
        }
        for(int k=0;k<m;k++){
            a.add(matrix[0][k]);
        }
        
        
        
        
    return Collections.min(a);}   
    }
