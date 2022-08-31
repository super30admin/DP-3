/*Time Complexity:O(N+K)
Space Complexity:O(N+K)
n is the length of nums and k is the maximum element in nums
*/
class Solution {
        
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> repetition = new HashMap<>();
        int max = -20000;
        int min = 20000;

        for(int i = 0; i < nums.length; i++) {
            repetition.compute(nums[i], (k,v) -> v == null ? 1 : ++v);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int[] memo = new int[max + 1];
        memo[0] = 0;
        memo[min] = (min * (repetition.get(min) == null ? 0 : repetition.get(min)));
        for(int i = 2; i <= max; i++) {
            memo[i] = Math.max(
				memo[i-2] + (i * (repetition.get(i) == null ? 0 : repetition.get(i))),
				memo[i-1]);
        }
        
        return memo[max];
    }
}