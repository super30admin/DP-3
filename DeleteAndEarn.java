public class DeleteAndEarn {
    /**
     * 1D tabulation DP optimized to use 2 variables to instead of 1D dp array
     * Logic is to choose between max of current element + 2 step back element or previous neighbor as we have to delete
     * neighboring elements incase we choose current element. Equivalent to House Robber problem
     *
     * Time: O(n) + O(max(n)) (whichever is greater) Space: O(max(n))
     */
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            max = Math.max(max, num);
        }

        int[] freqMap = new int[max + 1];
        for (int num: nums) {
            freqMap[num] += num;
        }

        int prev = freqMap[0];
        int curr = Math.max(prev, freqMap[1]);
        for (int i = 2; i < freqMap.length; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + freqMap[i]);
            prev = temp;
        }

        return curr;
    }
}
