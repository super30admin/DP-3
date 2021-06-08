class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # Time Complexity: O(N log N)
        # create a dict of the number of occurances of each element
        c = collections.Counter(nums)
        
        prev = None
        avoid = 0
        using = 0
        
        for k in sorted(c): # iterate through each item
            if k - 1 != prev: #
                avoid = max(avoid, using)
                using = k * c[k] + max(avoid, using)
            else:
                avoid = max(avoid, using)
                using = k * c[k] + avoid
            prev = k
        return max(avoid, using)