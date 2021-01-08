'''
    Time Complexity:
        O(n) (where n = length of the given array)

    Space Complexity:
        O(n) (where n = max in the given array)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Create an array of length of length n + 1, where arr[i] = sum of all i in the original array.
        Traverse this new array.
        In each traversal, cache:
            the output of choosing:
                this num and ignored from previous iterations
            the output of ignoring:
                max of previous ignored and chosen outcomes
        In the end, the output would be the max between choose and ignore from the last iteration of the array traversal.
'''
class Solution:
    def __init__(self):
        self.indexed_nums = []

    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0

        self.create_indexed_nums(nums)
        return self.maximize_earnings()

    def create_indexed_nums(self, nums):
        n = max(nums) + 1
        self.indexed_nums = [0] * n

        for num in nums:
            self.indexed_nums[num] += num

    def maximize_earnings(self):
        ignore = 0
        select = self.indexed_nums[0]
        max_earnings = max(ignore, select)

        for i in range(1, len(self.indexed_nums)):
            prev_ignore = ignore
            ignore = max_earnings
            select = prev_ignore + self.indexed_nums[i]
            max_earnings = max(ignore, select)

        return max_earnings
