// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarn {
        public int deleteAndEarn(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        for(int num : nums) 
            if(max < num) max = num;
        

        int[] arr = new int[max+1];

        for(int num : nums)
          arr[num] += num;
        

        int skip = 0, choose = arr[0];
        for(int i=0; i<arr.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip,choose);
            choose = prevSkip + arr[i];
        }

        return Math.max(skip,choose);
    }
}