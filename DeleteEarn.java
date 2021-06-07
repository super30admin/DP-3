/*TC - O(N)
 * SC - O(N)
 * Ram on leetcode - yes
 *
 * */


class Solution {
    public int deleteAndEarn(int[] nums) {
	// maximum number of elemets possible
        int n = 99999;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
		//use temporary vaiable since its overwritten
            int prev = skip + values[i];
            int max = Math.max(skip, take);
            take = prev;
            skip = max;
        }
        return Math.max(take, skip);
    }
}



