# Time Complexity: O(n)
# Space Complexity: O(1)
# ran on leetcode : Yes

from typing import List


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        # find max to initialize array length
        max_num = 0
        for i in nums:
            if max_num < i:
                max_num = i
        total_num = [0] * (max_num+1)
        # Add same array elements at the element position in array
        for num in nums:
            total_num[num] = total_num[num] + num
        # now it is just like house robber problem
        skip = 0
        take = total_num[0]

        for i in range(1, len(total_num)):
            prevSkip = skip
            skip = max(prevSkip, take)
            take = prevSkip + total_num[i]
        return max(skip, take)



print(Solution().deleteAndEarn([3, 4, 2, 4]))
