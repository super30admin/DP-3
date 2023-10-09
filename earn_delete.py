def deleteAndEarn(nums):
    if not nums:
        return 0
    
    # Find the maximum number in the given array.
    max_num = max(nums)
    
    # Create a new array to store the sum of points for each number from 1 to max_num.
    points = [0] * (max_num + 1)
    
    # Count the occurrences of each number in nums and accumulate points.
    for num in nums:
        points[num] += num
    
    # Apply dynamic programming to compute the maximum points.
    n = len(points)
    dp = [0] * n
    dp[1] = points[1]
    
    for i in range(2, n):
        dp[i] = max(dp[i-1], dp[i-2] + points[i])
    
    # Return the maximum points which are stored in dp[n-1].
    return dp[n-1]

# Example usage:
nums = [3, 4, 2]
max_points = deleteAndEarn(nums)
print("Maximum points:", max_points)
