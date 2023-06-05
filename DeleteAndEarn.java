/* DP solution with space optimized
Time complexity n(where n is the max value in nums)
Space complexity : constant */ 
class Solution{
        public int deleteAndEarn(int[] nums) {
                //we need to fix the data and make it predictable
                // find max value
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < nums.length; i++) {
                        max = Math.max(max, nums[i]);
                }

                int[] arr = new int[max + 1];
                for(int i = 0; i < nums.length; i++){
                        arr[nums[i]]+=nums[i];
                }

                int temp1 = 0;
                int temp2 = Math.max(temp1, arr[1]);
                int currMax = temp2;
                for(int index = 2; index <= max; index++) {
                        currMax = Math.max(temp2, arr[index] + temp1);
                        temp1 = temp2;
                        temp2 = currMax;
                }

                return currMax;
        }
}