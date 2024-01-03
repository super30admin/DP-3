#time complexity: O(n)
#space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Dynamic programming
# 1. Construct a dictionary to store accumulated sums
# 2. Iterate through the dictionary and calculate the maximum sum by taking the previous sum and the current sum
# 3. Return the maximum sum




class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        # Construct a dictionary to store accumulated sums
        num_map = {}
        max_val = float('-inf')
        min_val = float('inf')

        for num in nums:
            max_val = max(num, max_val)
            min_val = min(num, min_val)
            num_map[num] = num_map.get(num, 0) + num

        if len(num_map) < 2:
            return num_map[min_val]

        # Dynamic programming iteration
        prev = num_map[min_val]  # dummy
        curr = -1
        prev_key = min_val

        for i in range(min_val + 1, max_val + 1):
            if i in num_map:
                if i - prev_key > 1:
                    curr = prev + num_map[i]
                else:
                    curr = max(num_map[i], prev)
                prev_key = i
                break

        for i in range(prev_key + 1, max_val + 1):
            temp = curr
            if i in num_map:
                if i - prev_key > 1:
                    curr = curr + num_map[i]
                else:
                    curr = max(curr, prev + num_map[i])

                prev = temp
                prev_key = i

        return curr
  