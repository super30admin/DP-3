"""
Given an array nums of integers, you can perform operations on the array.
In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points.
6 total points are earned.

Solution:
    find maximum value in the array, and create a new array of size maximum value.
    assgin elements in the array as arr[nums[i]] = freq(nums[i]) * nums[i]
    for every element calculate the skip and take value

    if you do not choose that element skip = max(skip and take)
    if you choose current element then it would be previous skip value + current value

    time complexity - O(n)
    space complexity - O(max(nums))

"""

def deleteAndEarn(nums):
    maxi = max(nums)
    arr = [0]*(maxi +1)
    for n in nums:
        arr[n] += n
    skip, take = 0, arr[0]
    for i in range(1, len(arr)):
        temp = skip
        skip = max(skip, take)
        take = temp + arr[i]

    return max(skip, take)
print(deleteAndEarn([2,2,3,3,3,4,4]))
print(deleteAndEarn([3,4,2]))
print(deleteAndEarn([7,7,9,9,11,11]))