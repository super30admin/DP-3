// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : mp


// Your code here along with comments explaining your approach

/**
 * Creating an array with numbers as indexes and their relevant sums based on the occurrence.
 * Doing the linear lookup based on tabulation to get the maximum when we have to eliminate the numbers based on the selection.
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNumber = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        int result[] = new int[maxNumber + 1];
        result[1] = map.getOrDefault(1, 0);

        for (int i = 2; i < result.length; i++) {
            result[i] = Math.max(map.getOrDefault(i, 0) + result[i - 2], result[i - 1]);
        }

        return result[maxNumber];
    }
}