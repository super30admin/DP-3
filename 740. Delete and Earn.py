# Time: O(n) + O(max(n)) => writing 2 terms because whichever can be bigger
# Space: O(max(n)) => for the new array that we make
# After creating the new array it's similar to the house robber problem
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maximum = 0
        for num in nums:
            maximum = max(maximum,num)
        arr = [0] * (maximum + 1)
        for num in nums:
            arr[num] += num
        # House robber from here on with the new array 'arr'
        # dp_arr = [-1] * len(arr)
        prev = arr[0]
        curr = max(arr[0],arr[1])

        for i in range(2,(len(arr))):
            temp = curr
            curr = max(temp, prev + arr[i])
            prev = temp

        return curr