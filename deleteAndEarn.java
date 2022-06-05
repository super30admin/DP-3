// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class deleteAndEarn {
        public int deleteEarn(int[] nums) {
            int max = 0;
            for(int i=0; i<nums.length; i++){
                max = Math.max(nums[i],max);
            }
            int[] arr = new int[max+1];
            int i = 0;
            for(int j=0;j<nums.length;j++){
                i = nums[j];
                arr[i] = arr[i]+ i;
            }
            int prev = arr[0];
            int curr = Math.max(arr[0],arr[1]);
            for(i=2; i<arr.length;i++){
                int temp = curr;
                curr = Math.max(temp, prev+arr[i]);
                prev = temp;
            }
            return curr;
            
        }
    }

