// Time Complexity : Maximum of O(n) or O(max(n)) because we are iterating over both the frequency arr of size max(n) and original nums arr with size n
// Space Complexity : O(max(n)) max(n) is the biggest number in array; For frequency array;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* Created a frequency array to turn this into an exhaustive choose no choose dp approach.
* As the output of tree only depended on one input (where the index is), we use a 1d array; optimized to two variables
* If we choose one, we moved to index + 2; but if we dont we move to index + 1
*/

public class Problem1 {
    public int deleteAndEarn(int[] nums) {
        // find max number in array
        int max = 0;
        // O(n)
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // +1 so it's easy to get indexes without -1
        // space is O(max(n))
        int[] frequencyArr = new int[max + 1];

        // building frequency array
        for (int num : nums) {
            frequencyArr[num] += num;
        }

        if (frequencyArr.length == 1) {
            return frequencyArr[0];
        }

        if (frequencyArr.length == 2) {
            return Math.max(frequencyArr[0], frequencyArr[1]);
        }

        int prev = frequencyArr[0];
        // need first two houses to calculate the value for others
        int current = Math.max(frequencyArr[0], frequencyArr[1]);

        for (int i = 2; i < frequencyArr.length; i++) {
            // picking max of no choose and choose scenario as per the tree
            int temp = prev;
            prev = current;
            current = Math.max(prev, frequencyArr[i] + temp);
        }

        return current;
    }
}
