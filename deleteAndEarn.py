# Time Complexity O(n)
# Space Complexity O(n)
class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        upperLimit = max(nums) + 1
        store = [0] * upperLimit

        for num in nums:
            store[num] += num

        dp = [0] * upperLimit

        dp[1] = 1 * store[1]
        for i in range(2, upperLimit):
            dp[i] = max(dp[i - 2] + store[i], dp[i - 1])

        return dp[-1]


if __name__ == "__main__":
    
    sol = Solution()

    nums = [3, 4, 2]
    print(sol.deleteAndEarn(nums))   

    nums = [2, 2, 3, 3, 3, 4]
    print(sol.deleteAndEarn(nums))   
