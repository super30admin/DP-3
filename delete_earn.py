# Recursion:
# Time complexity: O(2^n)
# Space complexity: O(n)

def deleteAndEarn(nums):
    count = {}
    for num in nums:
        if num in count:
            count[num] += 1
        else:
            count[num] = 1

    def recursive_delete(num):
        if num not in count:
            return 0
        take = num * count[num] + recursive_delete(num - 2)
        not_take = recursive_delete(num - 1)
        return max(take, not_take)

    return recursive_delete(max(nums))

# Memoization:
# Time complexity: O(n)
# Space complexity: O(n)
def deleteAndEarn(nums):
    count = {}
    for num in nums:
        if num in count:
            count[num] += 1
        else:
            count[num] = 1

    memo = {}
    def recursive_delete(num):
        if num not in count:
            return 0
        if num in memo:
            return memo[num]
        take = num * count[num] + recursive_delete(num - 2)
        not_take = recursive_delete(num - 1)
        memo[num] = max(take, not_take)
        return memo[num]

    return recursive_delete(max(nums))



# Tabulation:
# Time complexity: O(n)
# Space complexity: O(n)
def deleteAndEarn(nums):
    count = {}
    for num in nums:
        if num in count:
            count[num] += 1
        else:
            count[num] = 1

    max_num = max(nums)
    dp = [0] * (max_num + 1)
    dp[1] = count.get(1, 0)

    for i in range(2, max_num + 1):
        take = i * count.get(i, 0) + dp[i - 2]
        not_take = dp[i - 1]
        dp[i] = max(take, not_take)

    return dp[max_num]
