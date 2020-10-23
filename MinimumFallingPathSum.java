//This problem was asked at Microsoft
//
//        It is given in the question that you are having an array of integers A. you have to calculate the minimum falling path through A. A falling path starts at any element in the first row , and must choose one element from each row and make sure to choose element from next row from a column whcih is different from the previous row's column by atmost one.
//        LeetCode - 931.
//
//
//        Example 1:
//
//        Input: [[1,2,3],[4,5,6],[7,8,9]]
//
//        Output: 12
//
//        Explanation:
//
//
//
//        The possible falling paths are:
//
//        [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
//        [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
//        [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
//        The falling path with the smallest sum is [1,4,7], so the answer is 12.

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : rec()
// Your code here along with comments explaining your approach
//Used Dynamic Programming. Wrote a three recursive function for fall back and calculate the min path out of it

class Solution {
    public int minFallingPathSum(int[][] A) {

        int size = A.length;
        int fr = A[0].length;
        int ans = Integer.MAX_VALUE;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            ans = Math.min(ans, rec(0,i,A, map));
        }
        return ans;
    }

    private static int rec(int i, int j, int arr[][], HashMap<String, Integer> map){

        int size = arr.length;
        int fr = arr[0].length;

        if(i == size){
            return 0;
        }

        if(j<0 || j>=size) return Integer.MAX_VALUE;

        String key = i +" "+j;
        if(map.containsKey(key))
            return map.get(key);

        int op1 = rec(i+1, j-1,arr, map);
        int op2 = rec(i+1, j,arr, map);
        int op3 = rec(i+1, j+1,arr, map);

        map.put(key,arr[i][j] + Math.min(op2,op3));
        return arr[i][j] + Math.min(op1, Math.min(op2,op3)) ;


    }
}