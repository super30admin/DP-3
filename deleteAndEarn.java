/*
740. Delete and Earn
Time Complexity: O(n + w) => w is width of the array => here 10,0001
Space Complexity: O(w)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];

        for(int num: nums)
            values[num] += num;

        int skip=0, take = 0;

        for(int i=0; i<values.length; i++){
            // int prev_skip = skip;
            // skip = Math.max(prev_skip, take);
            // take = prev_skip + values[i];
            int cur_take = skip + values[i];
            int cur_skip = Math.max(skip, take);
            take = cur_take;
            skip = cur_skip;
        }
        return Math.max(skip, take);
    }
}