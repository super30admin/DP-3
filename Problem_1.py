"""
Time Complexity : O(max(m,n)) where m is the length of array nums and n is the maximum number in array
nums
Space Complexity : O(n) where n is the maximum number in array nums
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Here, we can reduce this problem to house robber problem. Firstly, we can find the maximum number in the array
nums and make an array with that length. If we go over the array nums once sequentially now, and keep on
updating the new array with the total amount of that particular value, then the array that we are left
with is nothing but house robber problem. This is because, if we choose a number and want to earn it, we need to
delete the previous and next value, ie , we cannot earn values of previous and next number. This is 
similar to house robber as there also, if i want to rob a house, I cannot rob the previous and next house.
"""


class Solution(object):
    def deleteAndEarn(self, nums):
        if not nums:
            return 0
        mx = max(nums)
        arr = [0 for i in range(mx+1)]
        for i in nums:
            arr[i] += i
        nt_choose, choose = 0, 0
        for i in arr:
            nt_choose, choose = max(nt_choose, choose), i+nt_choose
        return max(nt_choose, choose)
