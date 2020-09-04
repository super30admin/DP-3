/*
740. Delete and Earn - MEDIUM
https://leetcode.com/problems/delete-and-earn/

Approach:
1. Brute force: O(2 ^ n), get all possible combinations of either choosing/not-choosing an element to delete
2. Second idea - try to sort, so that we can get nums[i]-1 and nums[i]+1 next to nums[i]
   But again, this is of no use, since an element could be repeated, and we again need to go 'n' left + right
   to find nums[i]-1 and nums[i]+1
3. Solution -
a. Notice how, we can collect all 2's, for example, together and delete 1 and 3 in the array
b. How to put all 2's (repeated elements), while also maintaing the order
    i. Sum all repeating elements 'i' and put in index 'i' of an array, and then delete arr[i-1] and arr[i+1]
c. Now this problem changes to =>
    i. If I select index 'i' and collect it's value, I'm not allowed to collect index 'i-1' and 'i+1'
    ii. This is similar to House robber problem
d. How to identify DP here?
    a. There's a choice to either select or not select an element
    b. We want to optmize for value collected

TC: O(n) + O(max_elem_in_array)
SC: O(max_element_in_array), since the sum of total occurences is stored for every element
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
*/

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;    
        }
        
        int max = getMax(nums);
        int sumArray[] = new int[max + 1];
        
        for (int i = 0; i < nums.length; i++) {
            sumArray[nums[i]] += nums[i];
        }
        
        int c = 0, dc = 0;
        
        for (int i = 0; i < sumArray.length; i++) {
            int tempDc = dc;
            dc = Math.max(c, dc);
            c = sumArray[i] + tempDc;
        }
        
        return Math.max(c, dc);
    }
    
    public int getMax(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
