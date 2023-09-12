class MinFallingPath {
    //TC will be O(N^2), as there is N*N matrix and there are 2 for loops
    //SC will be O(1), just mutating the matrix not creating the another
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0 ){      //Base condn to check if array is empty
            return 0;
        }
        int n = matrix.length;      //to get the length of the array.

        for(int i=n-2;i>=0;i--){    //to iterate over the matrix starting from second last row.
            for(int j=0;j<n;j++)     //to iterate over the columns.
                if(j==0){                   //Condn to check if it is first column
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i+1][j+1]);
                }
                else if(j == n-1){          //Condn to check if it is middle element
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j],matrix[i+1][j+1]));
                }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j<n ;j++){             //Condn to get the min value
            min =Math.min(min, matrix[0][j]);
        }
        return min;
    }


    public static void main(String[] args){
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        MinFallingPath obj = new MinFallingPath();
        System.out.println(obj.minFallingPathSum(matrix));
    }
}