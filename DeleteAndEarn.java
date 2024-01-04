// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DP

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        // This problem is a variation of House robber problem.
        int n = nums.length, max = 0;

        // I will find out the maximum element in the array
        for(int i = 0; i < n; i++) max = Math.max(max, nums[i]);

        // Now I will create an array of max + 1 size so that I could keep track of occurences of elements using count sort
        int[] result = new int[max + 1];

        // Keep track of occureneces
        for(int num : nums) result[num]++;

        // This is exactly same as house robber. In recursion I start from last index of result array and I have a choice 
        // to pick or not to pick. If I dont pick then thats fine I can go to index - 1. But if I chose to pick it then
        // I can't pick the previous index. Assume I picked index 6 which means the element is 6, then I can't pick 5 for 
        // sure. So just did a House robber tabulation here.
        for(int i = 2; i < max + 1; i++) result[i] = Math.max(result[i - 1], result[i] * i + result[i - 2]);

        return result[max];
    }
}