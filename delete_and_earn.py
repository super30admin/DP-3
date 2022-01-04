# tc : O(2n)
# sc : O(1)
from typing import Collection


class Solution(object):
    def deleteAndEarn(self, nums):
        count = Collection.Counter(nums)
        prev = None
        avoid = using = 0
        for k in sorted(count):
            if k - 1 != prev:
                avoid, using = max(avoid, using), k * count[k] + max(avoid, using)
            else:
                avoid, using = max(avoid, using), k * count[k] + avoid
            prev = k
        return max(avoid, using)