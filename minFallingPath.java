// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class minFallingPath {
        public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }

        int n=matrix.length;

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){ // below and diagonal right
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==n-1){ // below and diagonal left
                     matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{ // below and diagonal left,right
                     matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min=Math.min(min,matrix[0][j]);
        }
        return min;
    }

    public static void main(String[] args) {
    minFallingPath rs = new minFallingPath();
    int[][] arr = {
    {2, 1, 3},
    {6, 5, 4},
    {7, 8, 9}
    };
    int[][] arr2 = {
        {-19, 57},
        {-40, -5}
    };
    System.out.println(rs.minFallingPathSum(arr));  // ans = 13
    System.out.println(rs.minFallingPathSum(arr2));  // ans = -59
}

}