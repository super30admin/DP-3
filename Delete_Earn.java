// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = max(nums);

        int[] houses = new int[max+1];

        for(int num : nums){
            houses[num] += num;
        }

        for(int i=1; i<=max; ++i){
            houses[i] = Math.max(
                houses[i] + (i-2 < 0 ? 0 : houses[i-2]), //rob
                houses[i-1]//not rob
            );
        }

        return houses[max];
    }

    private int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(max, num);
        }
        return max;
    }
}