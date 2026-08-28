#Time Complexity : O(n + max(n))
#Space Complexity : O(max(n))
#Did this code successfully run on Leetcode :Yes
class Solution:   
   def deleteAndEarn(self, nums):
        from collections import defaultdict

        d = defaultdict(int)
        min_val = float('inf')
        max_val = 0

        for num in nums:
            d[num] += num
            max_val = max(max_val, num)
            min_val = min(min_val, num)

        prev = d[min_val]
        curr = prev
        if min_val + 1 in d:
            curr = max(prev, d[min_val + 1])

        for i in range(min_val + 2, max_val + 1):
            temp = curr
            if i in d:
                curr = max(curr, d[i] + prev)
            prev = temp

        return curr
