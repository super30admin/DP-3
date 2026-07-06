class Solution:
    def deleteAndEarn(self, nums):
        max_val = 0
        for num in nums:
            max_val = max(max_val, num)

        arr = [0] * (max_val + 1)
        for num in nums:
            arr[num] += num

        prev = arr[0]
        curr = max(arr[0], arr[1])

        for i in range(2, max_val + 1):
            temp = curr
            curr = max(curr, arr[i] + prev)
            prev = temp

        return curr


# TC - O(n+max(n))
# SC - O(max(n))