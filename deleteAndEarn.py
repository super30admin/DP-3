# TC: O(n + max(n))
# SC: O(n)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == []:
            return 0

        max_num = 0
        for i in nums:
            max_num = max(max_num, i)

        arr = [0] * (max_num + 1)
        for i in nums:
            arr[i] += i
        print(nums, arr)
        
        prev = arr[0]
        curr = arr[1]
        for i in range(2, len(arr)):
            temp = curr
            curr = max(curr,  arr[i] + prev)
            prev = temp

        return curr