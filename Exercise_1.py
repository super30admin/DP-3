# Time Complexity: O(n)
# Space Complexity: O(n)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: The DP logic of picking the current element and adding it compared to the 2D array approach

from collections import Counter

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        cnt = Counter(nums)
        nums = sorted(list(set(nums)))

        earn1, earn2 = 0, 0

        for i in range(len(nums)):

            curr_earned = cnt[nums[i]] * nums[i]

            if i > 0 and nums[i] == nums[i-1] + 1:
                # if prev element is 1 less than current element, then we go the skip logic
                # where we compare max of the curr earned + amount of the element two steps away 
                # and the prev skipped amount and assign it to the latest earned earn2
                temp = earn2
                earn2 = max(curr_earned+earn1, earn2)
                earn1 = temp
            else:
                # else we go to take logic
                # here we take the prev earned amount and current earned amount
                temp = earn2
                earn2 = curr_earned + earn2
                earn1  = temp

        return earn2
