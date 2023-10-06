/*
Time Complexity - O(n + max(nums))
Space Complexity - O(n)
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
    
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> earnings = new HashMap<Integer, Integer>();

        for(int num : nums) {
            max = Math.max(max, num); 
            earnings.put(num, earnings.getOrDefault(num, 0) + num);
        }
        
        int prev = earnings.getOrDefault(0, 0);
        int cur = earnings.getOrDefault(1, 0);

        for(int i = 2; i <= max; i++) {
            int temp = cur;
            cur = Math.max(cur, prev + earnings.getOrDefault(i, 0));
            prev = temp;
        }

        return cur;
    }
}
