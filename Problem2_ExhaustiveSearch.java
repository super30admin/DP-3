//Time Complexity: O(n*3^n)
//Space Complexity: O(n)
//Solution accepted but Time Limit exceeded due to Exhaustive Search.

public class Problem2_ExhaustiveSearch {

	public int minFallingPathSum(int[][] matrix) {
		
	if(matrix == null || matrix.length == 0)
		return -1;
	
	int m = matrix.length;
	int n = matrix[0].length;
	int amount = 0;
	
    int a = 0;
    int b = Integer.MAX_VALUE;
    for(int j=0; j <n; j++)
    {
        a = helper(matrix, 0, j, m, n, amount);
        if(a < b)
            b = a;
        
    }
	return b;
   }

	private int helper(int[][] matrix, int r, int c, int m, int n, int amount) {
	
		if(r <0 || r>m|| c <0 || c >=n)
			return Integer.MAX_VALUE;
		
		else if(r == m)
			return amount;
		
		//case1: directly below
		int c1 = helper(matrix, r +1, c, m, n, amount + matrix[r][c]);
		
		//case2: diagonal left
		int c2 = helper(matrix, r+1, c-1, m, n, amount + matrix[r][c]);
		
		//case3: diagonal right
		int c3 = helper(matrix, r+1, c+1, m, n, amount + matrix[r][c]);
	    
	    return Math.min(c1, Math.min(c2,c3));
    }
}
