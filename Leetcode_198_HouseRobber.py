#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        loot, prev=nums[0],0
        for num in nums[1:]:
            loot, prev=max(num+prev,loot),loot
        return loot