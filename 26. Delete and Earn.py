# Time Complexity: O(m) + O(n) where m is length of nums, n is max of nums
# Space Complexity: O(m) + O(n)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_nums = max(nums)
        list1 = [0 for i in range(max(nums) + 1)]
        for i in nums:
            list1[i] += i
        list1[1] = max(list1[0], list1[1])
        for i in range(2, len(list1)):
            list1[i] = max(list1[i-1], list1[i] + list1[i-2])
        # print(list1)
        return list1[len(list1)-1] 


