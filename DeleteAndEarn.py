# Time complexity O(n) n is the number elements in an array
# Space complexity O(1) because I am using variables

class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        # In this problem we cannot choose the adjacent values of array
        # So we first put sum of the all elements of the array over the indexes of the array
        maxNum = max(nums)
        arr = [0] * (maxNum + 1)
        for i in nums:
            arr[i] += i

        prev = arr[0]
        curr = arr[1]
        for i in range(2, len(arr)):
            temp = curr
            curr = max(curr, arr[i] + prev)
            prev = temp

        return curr

        # return self.helper(arr, 0, 0)

    def helper(self, arr, idx, points):
        # Base case
        if idx >= len(arr):
            return points

        # Choose
        r1 = self.helper(arr, idx + 1, points)

        # Not Choose
        r2 = self.helper(arr, idx + 2, points + arr[idx])

        return max(r1, r2)
