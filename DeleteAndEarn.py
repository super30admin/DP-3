# Problem1: (https://leetcode.com/problems/delete-and-earn/)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        countListSize = max(nums)+1
        countList = [0] * countListSize
        for i in nums:
            countList[i] += i
        prev = countList[0]
        curr = countList[1]
        for i in range(2,countListSize):
            temp = curr
            curr = max(curr, prev + countList[i])
            prev = temp
        return curr
    
#time complexity O(n) + O(max(n))
#space complexity O(max(n))