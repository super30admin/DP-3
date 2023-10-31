// Time Complexity : O(n*3^(n-1))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Time Limit Exceed. Ran on vs code
// Any problem you faced while coding this : No

// Brute Force

class Solution1 {
    int findSolution(int[][] matrix, int i, int j){
        if(j<0 || j>matrix.length-1){
            return Integer.MAX_VALUE;
        }
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        int curr= matrix[i][j];
        int leftDiagnol= findSolution(matrix,i+1,j-1);
        int down= findSolution(matrix,i+1,j);
        int rightDiagnol= findSolution(matrix,i+1,j+1);
        int min= Math.min(leftDiagnol,Math.min(down,rightDiagnol));
        return curr+min;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int min= Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            min= Math.min(min,findSolution(matrix,0,j));
        }
        return min;
    }
}




// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Bottom-Up Approach just like paint house

class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int[][] dp= new int[n+1][n];

        // populate the dp array using matrix from last row to first row
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++){
                int Leftdiagnol= j-1<0 ? Integer.MAX_VALUE : dp[i+1][j-1];
                int down= dp[i+1][j];
                int RightDiagnol= j+1>n-1 ? Integer.MAX_VALUE : dp[i+1][j+1];
                dp[i][j]= matrix[i][j]+ Math.min(Leftdiagnol,Math.min(down,RightDiagnol));
            }
        }
        //find the minimum element in first row
        int min=dp[0][0];
        for(int j=0; j<n-1; j++){
            min= Math.min(min,dp[0][j+1]);
        }
        return min;
    }
}




// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Bottom-Up Approach just like paint house

class Solution3 {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;

        //modufy the existing matrix from last row to first row
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int Leftdiagnol= j-1<0 ? Integer.MAX_VALUE : matrix[i+1][j-1];
                int down= matrix[i+1][j];
                int RightDiagnol= j+1>n-1 ? Integer.MAX_VALUE : matrix[i+1][j+1];
                matrix[i][j]= matrix[i][j]+ Math.min(Leftdiagnol,Math.min(down,RightDiagnol));
            }
        }
        //find the minimum element in first row
        int min=matrix[0][0];
        for(int j=0; j<n-1; j++){
            min= Math.min(min,matrix[0][j+1]);
        }
        return min;
    }
}

public class problem2{
    public static void main(String[] args) {
        int[][] matrix= {{2,1,3},{6,5,4},{7,8,9}};
        Solution1 s1= new Solution1();
        System.out.println(s1.minFallingPathSum(matrix));
        Solution2 s2= new Solution2();
        System.out.println(s2.minFallingPathSum(matrix));
        Solution3 s3= new Solution3();
        System.out.println(s3.minFallingPathSum(matrix));
    }
}