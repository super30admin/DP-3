// Time Complexity : O(N+k)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Find the maximum value in nums so we can create an array of size max + 1
// arr[i] stores the total points earned by taking all occurrences of number i
// House Robber logic: prev represents the best answer up to i - 2 and curr represents the best answer up to i - 1
class DeleteAndEarn{
    public int deleteAndEarn(int[] nums) {
       
        int max =Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int []arr = new int[max+1];

        for(int num : nums){
            arr[num] += num;
        }
        
        int prev = arr[0];
        int curr = Math.max(prev, arr[1]);

        for(int i = 2; i < arr.length; i++){
             int temp = curr;
             curr = Math.max(curr, prev+arr[i]);
             prev= temp;
        }

        return curr;
    
    }
}
