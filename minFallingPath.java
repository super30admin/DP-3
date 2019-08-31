//Time Complexity:O(N^2) 
//Space Complexity:O(1)
//In this program, I'll be moving from bottom to top, where I'll consider the min from the last row corresponding to the column in the last-1 row and add the min to that particular element in that column. This will be done iteratively. Post which, the first element will be set as the min and then it'll be iteratively compared with all the other elements in the first row and the minimum will be found and returned.
//This code was successfully executed and got accepted in leetcode.


class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i=A.length-2;i>=0;i--){
            for (int j=0;j<A[0].length;j++){
                int min=A[i+1][j];
                if(j>0){
                    min = Math.min(min,A[i+1][j-1]);
                }
                if(j<A[0].length-1){
                    min=Math.min(min,A[i+1][j+1]);
                }
                A[i][j]=A[i][j]+min;
            }
        }
        int min =A[0][0];
        for(int i=0;i<A[0].length;i++){
            if(A[0][i]<min){
                min=A[0][i];
            }
        }
        return min;
    }
}