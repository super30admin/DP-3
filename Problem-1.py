"""
## Problem1: (https://leetcode.com/problems/delete-and-earn/)

Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3, 4, 2]

Output: 6

    Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
    Then, delete 2 to earn 2 points. 6 total points are earned.

Example 2:

Input: nums = [2, 2, 3, 3, 3, 4]

Output: 9

    Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
    Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.9 total points are earned.

Note: The length of nums is at most 20000.
      Each element nums[i] is an integer in the range [1, 10000].

// Time Complexity : O(max(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

"""

def Delete_array(nums):
    if nums == None or len(nums) == 0:  # check if given list is empty or not
        return 0
    arr=[0]*(max(nums)+1)          #create array of size of max element in nums list+1 ( +1 to include 0 )
    arr[0]=0                       # to consider all possible values

    for i in range(len(nums)):     # add numbers from nums at respective index like if nums is 4, add it at 4th index
        arr[nums[i]] += nums[i]

    skip=0                # for index 0 skip or take both are zero
    take=0
    for i in range(1,len(arr)):   # we start from index 1
        temp=skip                 #store skip in temo as we need to use it further
        skip=max(temp,take)       # when we skip any number then we tak the maximum from skip or take from previous number
        take=temp+arr[i]          # if we take the number then we add the skip from previous number stored in temp + current number from arr
        print(temp,skip)
    return max(skip,take)        # return maximum of skip or take from last number of arr



print(Delete_array(nums = [2, 2, 3, 3, 3, 4]))