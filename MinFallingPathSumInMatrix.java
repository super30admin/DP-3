//TC O(n*n)- row*col
//SC O(1)
//we will reuse the same matrix to calulate the dp matrix values

//works in leetcode
class MinFallingPathSumInMatrix {
    //minimum falling path from 0th row to to reach i,j
    public static int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        for(int i=1;i< n;i++){ // first row values are same

            for(int j=0;j<n;j++){
                int diagLeft = j==0? Integer.MAX_VALUE : matrix[i-1][j-1];
                int up = matrix[i-1][j];
                int diagRight = j==n-1 ? Integer.MAX_VALUE:matrix[i-1][j+1];

                matrix[i][j] += Math.min(diagLeft, Math.min(up, diagRight));
            }


        }
        int output = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
            output=  Math.min(output,matrix[n-1][j]);
        return output;

    }



    public static void main(String [] args){
        int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        System.out.println(minFallingPathSum(matrix));

    }
}