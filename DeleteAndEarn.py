# Time complexity: O(N)
# Space complexity: O(N)

# Compiled successfully on leetcode: Yes

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        numSum = [0 for i in range(max(nums) + 1)]
        chosen = []
        notChosen = []
        for num in nums:
            numSum[num] += num
        chosen.append(numSum[0])
        notChosen.append(0)
        for i in range(1, len(numSum)):
            # Not chosen
            notChosen.append(max(chosen[-1], notChosen[-1]))
            # Chosen
            chosen.append(numSum[i] + notChosen[-2])
        return max(chosen[-1], notChosen[-1])