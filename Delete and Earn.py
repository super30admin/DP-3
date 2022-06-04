# time complexity is o(n) + o(max(n)), where n is the size of the input and max(n) is the maximum element in the given input of size n
# space complexity is o(1)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if(len(nums) == 0):
            return 0
        m = 0
        for i in nums:
            m = max(m,i)
        arr = [0 for i in range(m+1)]
        for i in nums:
            arr[i] += i
        prev = arr[0]
        curr = max(arr[0], arr[1])
        for i in range(2,len(arr)):
            temp = curr
            curr = max(temp, arr[i] + prev)
            prev = temp
        return curr
        