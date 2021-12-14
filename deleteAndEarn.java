/*
Question: Here we are given an array and we have to select any number and do the following:
Add all occurences of that number + Add all the other numbers in that array but not the all occurences of (number picked -1) and all occurunces of (number picked +1)

[2,2,3,3,3,4]
if we pick 2 add all occurences of 2 delete all occurrences of (2+1) and (2-1)

T.c -> O(maxvalue + n) //maximum number in array
S.C -> O(maxvalue)
*/
class Solution {
    public int deleteAndEarn(int[] nums) {

        int max_ele = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length;i++){
            max_ele = Math.max(max_ele, nums[i]);
        }
        int[] temp = new int[max_ele + 1];

        for(int i = 0; i < nums.length;i++){
            temp[nums[i]] += nums[i]; 
        }

        int[][] dp = new int[temp.length+1][2];

        for(int r = 1; r < dp.length;r++){
            dp[r][0] = Math.max(dp[r-1][0], dp[r-1][1]);
            dp[r][1] = dp[r-1][0] + temp[r-1];
        }

        return Math.max(dp[dp.length -1][0] , dp[dp.length-1][1]);
    }


} 