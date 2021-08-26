// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int range = 10000;
        int points[] = new int[range + 1];
        for(int num : nums) {
            points[num] += num;
        }
        
        int secondNum = points[0];
        int firstNum = Math.max(points[0], points[1]);
        
        for(int i = 2; i < points.length; i++) {
            int thirdNum = Math.max(firstNum, secondNum + points[i]);
            secondNum = firstNum;
            firstNum = thirdNum;
        }
        
        return firstNum;
    }
}