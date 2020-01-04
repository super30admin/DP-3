from typing import List
from math import inf


class Solution:
    # class variable
    max_value = -inf

    def deleteAndEarn(self, nums: List[int]) -> int:
        """
            https://leetcode.com/problems/delete-and-earn/
            // Time Complexity : O(N)
            // Space Complexity : O(N)
            // Did this code successfully run on Leetcode :
            // Any problem you faced while coding this :
                    Taken from Ram's approach
            // Your code here along with comments explaining your approach
                    Reduce this problem to house robber, for each number
                    we take a decision to choose the current number or not.
                    If we donot choose the current number,
                        we can simply take the max of the previous_chosen and
                        previous_not_chosen
                    If we are deciding to choose a number, there are two possibilites -
                        1) If the immediate previous number exists, then we cannot choose it.
                           But we can choose the previous_not_chosen (the sum we would
                           have got if we had not chosen the previous number) plus the
                           current number
                        2) If the immediate previous number does not exists, then we have an option
                           to choose it as well because the question demands to only not choose the
                           number-1 . Now we can take the max of the previous_chosen and
                           previous_not_chosen plus the current number.
        """
        if not nums or len(nums) == 0:
            return 0

        dic = {}

        for num in nums:
            if num not in dic:
                dic[num] = num
            else:
                dic[num] += num

        cur_not_choose = 0
        cur_choose = 0

        for num in range(1, max(nums) + 1):
            if num in dic:
                prev_not_choose = cur_not_choose
                prev_choose = cur_choose
                # If I don't choose the current number
                # I have the option to choose or not choose
                # the previous one. I take max from them
                cur_not_choose = max(prev_not_choose, prev_choose)
                # Since the immediate previous number is not present
                if num - 1 not in dic:
                    # we have no restriction, we can choose the previous
                    # number as well
                    cur_choose = dic[num] + max(prev_choose, prev_not_choose)
                # Since immediate previous number is present
                else:
                    # we cannot choose the prev number
                    cur_choose = dic[num] + prev_not_choose
        return max(cur_choose, cur_not_choose)

    def deleteAndEarnBruteForce(self, nums: List[int]) -> int:
        """
           // Time Complexity : Exponential
           // Space Complexity : O(n) if we take stack space, else O(1)
           // Did this code successfully run on Leetcode : TLE
           // Any problem you faced while coding this :
                    Recursion is always hard for me
        """
        self.max_value = -inf
        if not nums:
            return 0
        # choose the first value
        self._helper(nums, 0, 0)
        # don't choose the first value
        self._helper(nums, 1, 0)
        return self.max_value

    def _helper(self, nums: List[int], index: int, t_sum: int):
        # skipping all values in nums that have zero's
        # zero's won't add anything to our sum
        while index < len(nums) and nums[index] == 0:
            index += 1
        # base case
        if index == len(nums):
            return

        ori_arr = nums[:]
        ori_sum = t_sum

        prev = nums[index] - 1
        next = nums[index] + 1

        for j in range(index, len(nums)):
            if nums[j] == next or nums[j] == prev:
                nums[j] = 0
        # choosing
        t_sum += nums[index]
        self.max_value = max(self.max_value, t_sum)
        self._helper(nums, index + 1, t_sum)
        # not choosing
        self._helper(ori_arr, index + 1, ori_sum)


if __name__ == '__main__':
    sol = Solution()
    print(sol.deleteAndEarnBruteForce([1, 2, 6, 5]))
    print(sol.deleteAndEarnBruteForce([3, 4, 2]))
    print(sol.deleteAndEarnBruteForce([2, 2, 3, 3, 3, 4]))
    print(sol.deleteAndEarnBruteForce([2, 2, 3, 3, 3, 5, 7]))
    print(sol.deleteAndEarn([3, 4, 2]))
    print(sol.deleteAndEarn([2, 2, 3, 3, 3, 5, 7]))
