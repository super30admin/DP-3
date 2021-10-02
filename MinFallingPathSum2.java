class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //not added null check because of constraint given 
        
        for(int i=1;i < matrix.length;i++){
            for(int j=0;j < matrix[0].length;j++){
                if(j==0){ //first col
                    matrix[i][j]+= Math.min(matrix[i-1][j],matrix[i-1][j+1]); //j=0th Column
                }
                else if(j== matrix[0].length-1){ ///last col
                    matrix[i][j]+= Math.min(matrix[i-1][j-1],matrix[i-1][j]);  //j=column-1/last column
                }
                else { //all other cols
                    int min = Math.min( matrix[i-1][j] , matrix[i-1][j-1] );
                    matrix[i][j]+= Math.min(min,matrix[i-1][j+1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : matrix[matrix.length-1]){
            min=Math.min(i,min);
        }
        return min;
    }
}

//time: O(n*m)
//space :O(1) no extra space used
//ran successfully on leetcode
//didnt find difficulty just took so much time around 2 hours to implement which is way more than interview slot given in normal scenerio. Dont know how to tackle that. Facing difficulty with time.
//Approach : DP calculating minimum at each level path  and summing to the current value to reach the final level and again calculating min out of it.
