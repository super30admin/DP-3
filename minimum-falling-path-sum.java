// Time Complexity : O(n) n: input size
// Space Complexity : Top down : O(n) and Bottom up: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Min at any postion will be its sum with min of next row neighbour elements


//Top Down
public int minFallingPathSum(int[][] A) {
    int result = Integer.MAX_VALUE;
    boolean[][] visited = new boolean[A.length][A[0].length];
    for(int j = 0;j< A[0].length;j++){
            result = Math.min(result, helper(A,0,j,visited));
    }
    return result;
}
private int helper(int[][] A,int i, int j, boolean visited[][]){
    if(i == A.length-1) return A[i][j];
    if(visited[i][j]) return A[i][j];
    A[i][j] += Math.min(Math.min(j>0?helper(A,i+1,j-1,visited):Integer.MAX_VALUE, helper(A,i+1,j,visited)),j<A[0].length-1?helper(A,i+1,j+1,visited):Integer.MAX_VALUE);
    visited[i][j] = true;
    return A[i][j];
}

//Bottom up
public int minFallingPathSum(int[][] A) {
    int result = Integer.MAX_VALUE;
    int n = A.length;
    int m = A[0].length;
    for(int i = n-2; i>=0;i--){
        for(int j = 0; j< m;j++){
            A[i][j] += Math.min(Math.min(j>0?A[i+1][j-1]:Integer.MAX_VALUE, A[i+1][j]),j<m-1?A[i+1][j+1]:Integer.MAX_VALUE);
        }
    }
    for(int j = 0; j< m;j++){
        result = Math.min(result,A[0][j]);
    }
    return result;
}