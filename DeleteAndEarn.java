public class DeleteAndEarn {
    /*
time : O(n)
Space : O(n)
*/

        public int deleteAndEarn(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int max = Integer.MIN_VALUE;

            int n = nums.length;

            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
            }

            int[] arr = new int[max+1];

            for(int num : nums){
                arr[num] += num;
            }

            // house robber on array arr

            int prev = arr[0];
            int curr = Math.max(prev, arr[1]);

            for(int i = 2; i < arr.length; i++){
                int temp = curr;
                curr = Math.max(curr, prev + arr[i]);
                prev = temp;
            }

            return curr;

        }

}
