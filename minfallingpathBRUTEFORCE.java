// Time complexity : O(n^2)
// Space complexity: O(1)

// The code is similar to house paint but instead of 3 colors, here we are taking a for loop for each column . And in the recursive function,
// we have seperate cases for if column is first and last and for the middle

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A==null || A.length==0) return 0;
        int result=99999;
        for(int i=0;i<A[0].length;i++){
            result=Math.min(result,helper(A,0,i,0));
        }
        return result;
    }
    
    private int helper(int[][] A,int index,int path,int min){
        if(index>=A.length){
            return min;
        }
       int res = 9999;  
        if(path==0 && path==A.length-1){
            return Math.min(res,A[index][path]);
        }
        if(path==0){
            res=Math.min(res,Math.min(helper(A,index+1,path,min+A[index][path]),helper(A,index+1,path+1,min+A[index][path+1])));
        }
        else if(path==A[0].length-1){
            res=Math.min(res,Math.min(helper(A,index+1,path-1,min+A[index][path-1]),helper(A,index+1,path,min+A[index][path])));
        }
        else{
                res=Math.min(res,Math.min(helper(A,index+1,path-1,min+A[index][path-1]),Math.min(helper(A,index+1,path,min+A[index][path]),helper(A,index+1,path+1,min+A[index][path+1]))));
            }
        
        return res;
    }
}