# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #create a list to store the numbers in the array and store the total value (occurences*number)
        pre = [0 for _ in range(max(nums) + 1)]
        for i in nums:
            pre[i] += i
        # if nums = [1,2,2,3,3,3,4] pre would be [0,1,4,9,4]
        # Here we take 2 variables leave and take to simulate a 2d arrary it 0,1 indicating
        # the case when we leave an element or take an element
        leave = 0
        take = pre[0]

        # we go over the array and maintain the leave and take variables
        # for the leave part we can choose the max of the 2 cases above since there is restriciton only if we decide to take an element
        # for the take we choose the last 0(or not taken) case since we can't take adjacent elements
        # and add the total value of that element(if 3 occurs 3 times, then 9 will be added) to the current element
        for i in range(1, len(pre)):
            proxy = leave
            leave = max(leave,take)
            take = proxy + pre[i]

        return max(leave, take)