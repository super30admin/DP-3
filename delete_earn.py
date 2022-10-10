#TC O(n)
#SC O(1)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        freq_map = [0] * (max(nums) + 1)

        for num in nums:
            freq_map[num] += 1
        prev1, prev2 = 0, 0
        for num in range(1, len(freq_map)):
            skip = prev1
            take = num * freq_map[num] + prev2
            prev2 = prev1
            prev1 = max(take, skip)
        return prev1