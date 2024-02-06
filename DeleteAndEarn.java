//Time Complexity = O(n + max(n))
//Space Complexity = O(max(n)) // Worst
// Does it run on LeetCode successfully? : Yes
// Any difficulties: Clicking logic in an interview is key. I am still able to derive after watching video.

/*
Bucket the numbers and count its max earning.

Get Max from num's array. Create another 0 to max(n) length array which is max+1 as sometime 0 (zero) number may not exist.
Then get number from number's array go that index and add all that number's frequency. This new max array is similar array like house robber.
After finding DP pattern, using 2 variables, we are able to derive solution.
At the end return curr as a result.
*/

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int earning = 0;
        if(nums == null || nums.length == 0) return earning;
        if(nums.length == 1) return nums[0];
        int maxValue = Integer.MIN_VALUE;

        for(int num: nums) { //bucking numbers with their occurence on their respective index
            maxValue = Math.max(num, maxValue);
        }

        int[] max = new int[maxValue+1];

        for(int num: nums){
            max[num] += num;
        }
        int prev = max[0];
        int curr = Math.max(max[0], max[1]);

        for(int i = 2; i<max.length; i++){
            int temp = curr;
            curr = Math.max(curr, max[i]+prev);
            prev = temp;
        }
        earning = curr;
        return earning;
    }

    public static void main(String[] args){
        DeleteAndEarn de = new DeleteAndEarn();
        int[] nums = {2,2,3,3,3,4};
        System.out.println("Maximum points earned: " + de.deleteAndEarn(nums));
    }
}