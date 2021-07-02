//Time complexity: O(N + M), where N is the length of nums array and M is the maximum element in nums array. 
//Space complexity: O(A), where A is the length of arr array.
// Did this code successfully run on Leetcode : https://leetcode.com/submissions/detail/516413528/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0; 
        
        // converted the problem to house robber problem by creating an auxiliary array, which would sort the array and maintain the occurence frequency of each element. 
        int maxNum = -1; 
        int  arr[] = new int[10001]; 
        for(int num: nums) {
            arr[num]++; 
            maxNum = Math.max(maxNum, num); 
        }
        
        int a = arr[1]; 
        int b = Math.max(arr[1], 2*arr[2]); 
        for(int i=3; i<=maxNum; i++) {
            int max = Math.max(a+(i*arr[i]), b); 
            a = b;
            b = max;
        }
        return b;
    }
}