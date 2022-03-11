import java.util.Arrays;

// Time Complexity : O (n.m.log m); Where n =number of rows and m= number of columns in matrix
// Space Complexity : O(log m); where m is number of columns in matrix
public class MinFallPathSum {
	public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;  
            
        //Bottom Up: Fill matrix with cumulative min sum
        for(int i=matrix.length-2; i>=0; i--){
            for(int j=0; j<matrix[0].length; j++){
                if(j==0){
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j] ,matrix[i+1][j+1]);
                }else if(j==matrix[0].length-1){
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j-1] ,matrix[i+1][j]);
                }else{
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i+1][j-1] ,Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }                
            }            
        } 
        //result is minimum of top row
        Arrays.sort(matrix[0]);
        return matrix[0][0];
    }
	
	// Driver code to test above 
	public static void main(String[] args) {
		MinFallPathSum ob= new MinFallPathSum();
		int[][] arr= {{2,1,3},{6,5,4},{7,8,9}};
		System.out.println("Min falling path sum is: "+ ob.minFallingPathSum(arr));
	}
}
