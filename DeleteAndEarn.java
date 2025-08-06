//The problem involves an array of unsorted and potentially repeating elements. The key constraint is that if we choose an element, we earn points equal to the sum of all its occurrences in the array. However, once we choose an element, we must delete all instances of the numbers that are one less and one more than the chosen number. This makes a straightforward recursive approach difficult, as we would need to modify the array at each step, and a simple pointer-based traversal wouldn’t capture the problem dynamics.
// To address this, I first created a frequency array where each index represents a number from the input array, and the value at that index is the total points we can earn by choosing that number (i.e., the number multiplied by its frequency). To determine the size of the frequency array, I calculated the maximum number present in the input array. Once this frequency array is built, the problem transforms into a variation of the classic "House Robber" problem. In this analogy, if we choose to earn points from one number, we must skip its immediate neighbors (i.e., adjacent indices in the frequency array).
// To solve this, I used a 1D dynamic programming (DP) array. The first index of the DP array represents the case where we only have one number, so its value is simply the points we earn from that number. The second index compares the first two numbers, and we take the maximum of the two. For every subsequent index i, we have two choices: either skip the current number and take the value from dp[i - 1], or choose the current number and add its points to dp[i - 2], effectively skipping its adjacent.
//So here if you observe that from how we structured the DP array.  we don't actually need the entire dp Array. We just need the values of the two previous cells prior to the current index so instead of having a matrix I'm having two pointers which can efficiently track the two previous values and then update pointers accordingly that way the pointer that's pointing to the last cell would efficiently give me the result by doing this I'm optimizing the space.
//time complexity would be O(n)- getting the max, processing the array which would be O(max),so it would be O(n)+O(max)
//space here would be O(max) since items is the only extra storage that we are using.
class Solution {
    public int deleteAndEarn(int[] nums) {
        //int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        //getting the max and min in the nums array
        for(int i=0;i<nums.length;i++){
            //min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int[] items=new int[max+1];//if i include min length =max-min+1
        //we are processing the array
        for(int i:nums){
            items[i]+=i;//item[i-min]
        }
        //getting the maximum(similar to house robbers problem)
        if(items.length==1)return items[0];
        int prev=items[0];
        int cur=Math.max(items[0],items[1]);

        for(int i=2;i<items.length;i++){
            int temp=cur;
            cur=Math.max(cur,prev+items[i]);
            prev=temp;
        }
        return cur;

     }
}
