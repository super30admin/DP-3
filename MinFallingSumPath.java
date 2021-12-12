// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No





public class MinFallingSumPath {
        public int minFallingPathSum(int[][] matrix) {
            if(matrix.length==0 ||matrix==null){
                return 0;
            }
            int n=matrix.length;
            int m=matrix[0].length;
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<m;j++){
                    if(j==0){
                        matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                        
                    }
                    else if(j==m-1){
                        matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                    }
                    else{
                        matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j+1],matrix[i+1][j]));
                    }
                }
            }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<m;i++){
                min=Math.min(min,matrix[0][i]);
                
            }
            return min;
        }
        public static void main(String args[]){
            MinFallingSumPath obj=new MinFallingSumPath();
            int[][] matrix={{2,1,3},{6,5,4},{7,8,9}};
            System.out.println(obj.minFallingPathSum(matrix));
        }
}
