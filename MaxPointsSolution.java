// Time Complexity : O(n^2 + n) = O(n^2)
// Space Complexity : O(1) // changing given matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MaxPointsSolution {
    public int deleteAndEarn(int[] nums) {
        int[] all = new int[10001]; // given in constraints
        for (int num : nums){
            all[num] += num; // [0, 0, 2, 3, 4, 0, 0...] --> sorts them and also places in 0s
        }
        
        int selectPrev = 0;
        int skipPrev = 0;
        
        for (int i = 0; i < all.length; i++){
            int selectCurr = skipPrev + all[i];
            int skipCurr = Math.max(selectPrev,skipPrev);
            
            selectPrev = selectCurr;
            skipPrev = skipCurr;
            
        }      
        return Math.max(selectPrev, skipPrev);
    }
       
}