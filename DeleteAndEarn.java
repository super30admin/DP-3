// Time Complexity : O(n) + O(max) where n is the length of given array and max is the max element in given array
// (since we create a new array of size max to calculate our answer)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode  : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class DeleteAndEarn{
        public int deleteAndEarn(int[] nums) {

            if(nums == null || nums.length == 0)
                return 0;

            int max = nums[0];

            for(int num : nums){
                max = Math.max(max,num);
            }

            int[] res = new int[max + 1];

            for(int num: nums){
                res[num] += num;
            }

            int prev = 0;
            int curr = res[1];

            for(int i = 2; i < res.length ; i++){
                int temp = curr;
                curr = Math.max(curr , prev + res[i]);
                prev = temp;
            }
            return curr;
        }
}
