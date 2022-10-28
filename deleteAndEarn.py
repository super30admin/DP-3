#Time Complexity: O(n)
#Space Complexity: O(n)
#Did it run on leetcode: Yes

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_ele = max(nums)
        arr = [0]*(max_ele+1)
        for num in nums:
            arr[num] += num
        prev = 0
        curr = arr[1]
        for index in range(2, max_ele +1):
            temp = curr
            curr = max(curr, prev + arr[index])
            prev = temp
        return curr